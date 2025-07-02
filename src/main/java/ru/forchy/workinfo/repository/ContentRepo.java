package ru.forchy.workinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.forchy.workinfo.entity.Content;

import java.util.Optional;

/**
 * Класс, реализующий интерфейс репозитория в JPA
 * Необходим для выполнения операций с сущностью контента
 */

@Repository
public interface ContentRepo extends JpaRepository<Content, Long> {
    Optional<Content> findByTag(String tag);
}
