package ru.salikhov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.salikhov.entity.RegistrationEntity;
import ru.salikhov.entity.SocksEntity;
import ru.salikhov.repositories.SocksRepo;

@Service
public class SocksService {

    @Autowired
    private SocksRepo socksRepo;

    public ResponseEntity income(SocksEntity socks) {
        int quantity = socks.getQuantity();
        SocksEntity findSocks = socksRepo.findSocksEntityByColorEqualsAndCottonPartEquals(socks.getColor(), socks.getCottonPart());

        if (findSocks != null) {
            socks = findSocks;
            socks.setQuantity(quantity + findSocks.getQuantity());
        }

        socks.addRegistration(new RegistrationEntity("income", quantity));
        socksRepo.save(socks);
        return ResponseEntity.ok("Socks saved");
    }

    public boolean outcome(SocksEntity socks) {
        int quantity = socks.getQuantity();
        SocksEntity findSocks = socksRepo.findSocksEntityByColorEqualsAndCottonPartEquals(socks.getColor(), socks.getCottonPart());

        if (findSocks == null || quantity > findSocks.getQuantity()) {
            return false;
        }
        findSocks.setQuantity(findSocks.getQuantity() - quantity);
        findSocks.addRegistration(new RegistrationEntity("outcome", quantity));
        socksRepo.save(findSocks);
        return true;
    }

    public int get(String color, String operation, int cottonPart) {
        int count = 0;
        switch (operation) {
            case "moreThan":
                count = socksRepo.streamSocksEntitiesByColorAndCottonPartGreaterThan(color, cottonPart)
                        .mapToInt(SocksEntity::getQuantity).sum();
                return count;
            case "equal":
                count = socksRepo.streamSocksEntitiesByColorAndCottonPartEquals(color, cottonPart)
                        .mapToInt(SocksEntity::getQuantity).sum();
                return count;
            case "lessThan":
                count = socksRepo.streamSocksEntitiesByColorAndCottonPartLessThan(color, cottonPart)
                        .mapToInt(SocksEntity::getQuantity).sum();
                return count;
        }
        return count;
    }
}
