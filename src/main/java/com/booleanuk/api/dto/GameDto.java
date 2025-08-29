package com.booleanuk.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameDto {
    private String title;
    private String genre;
    private String publisher;
    private String developer;
    private int releaseYear;
    private boolean isEarlyAccess;
}
