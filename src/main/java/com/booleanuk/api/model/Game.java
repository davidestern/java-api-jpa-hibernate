package com.booleanuk.api.model;

import com.booleanuk.api.dto.GameDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String genre;
    private String publisher;
    private String developer;
    private int releaseYear;
    private boolean isEarlyAccess;

    public Game(GameDto gameDto) {
        setTitle(gameDto.getTitle());
        setGenre(gameDto.getGenre());
        setPublisher(gameDto.getPublisher());
        setDeveloper(gameDto.getDeveloper());
        setReleaseYear(gameDto.getReleaseYear());
        setEarlyAccess(gameDto.isEarlyAccess());
    }
}
