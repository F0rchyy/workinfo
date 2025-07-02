package ru.forchy.workinfo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс, реализующий сущность пользователя
 * Необходим для представления данных из БД в Java с помощью JPA
 */

@Entity
@Table(name = "users", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(unique = true)
    private String username;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String role;

    @Getter
    @Setter
    @Column(unique = true)
    private String email;
}
