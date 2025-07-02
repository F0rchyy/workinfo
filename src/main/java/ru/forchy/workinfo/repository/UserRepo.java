package ru.forchy.workinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.forchy.workinfo.entity.User;

import java.util.Optional;

/**
 * Класс, реализующий интерфейс репозитория в JPA
 * Необходим для выполнения операций с сущностью пользователя
 */

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
