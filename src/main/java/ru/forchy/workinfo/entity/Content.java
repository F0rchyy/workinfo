package ru.forchy.workinfo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "content", schema = "public")
@ToString
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    private String tag;

    @Getter
    @Setter
    private String content;
}
