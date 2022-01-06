package ru.salikhov.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.salikhov.entity.SocksEntity;

import java.util.stream.Stream;

public interface SocksRepo extends CrudRepository<SocksEntity, Long> {
    SocksEntity findSocksEntityByColorEqualsAndCottonPartEquals(String color, int cottonPart);
    Stream<SocksEntity> streamSocksEntitiesByColorAndCottonPartGreaterThan(String color, int cottonPart);
    Stream<SocksEntity> streamSocksEntitiesByColorAndCottonPartEquals(String color, int cottonPart);
    Stream<SocksEntity> streamSocksEntitiesByColorAndCottonPartLessThan(String color, int cottonPart);

}
