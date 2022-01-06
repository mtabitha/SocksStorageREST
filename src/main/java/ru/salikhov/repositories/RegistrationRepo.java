package ru.salikhov.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.salikhov.entity.RegistrationEntity;

public interface RegistrationRepo extends CrudRepository<RegistrationEntity, Long> {
}
