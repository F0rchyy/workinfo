package ru.forchy.workinfo.repository;

import ru.forchy.workinfo.entity.Content;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContentRepo extends JpaRepository<Content, Long> {
    Optional<Content> findByTag(String tag);
}
