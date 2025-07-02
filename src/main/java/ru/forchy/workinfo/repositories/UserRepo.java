package ru.forchy.workinfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.forchy.workinfo.entities.User;

import java.util.Optional;

/**
 * Класс, реализующий интерфейс репозитория в JPA
 * Необходим для выполнения операций с сущностью пользователя
 */

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsernameIgnoreCase(String username);

    boolean existsByUsernameIgnoreCase(String username);

    Optional<User> findByEmailIgnoreCase(String email);

    boolean existsByEmailIgnoreCase(String email);
}
