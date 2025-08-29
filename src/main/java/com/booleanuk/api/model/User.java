package com.booleanuk.api.model;

import com.booleanuk.api.dto.UserDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String firstName;
    private String lastName;
    private String username;
    // private Boolean isActive;

    public User(UserDto userDto) {
        setEmail(userDto.getEmail());
        setFirstName(userDto.getFirstName());
        setLastName(userDto.getLastName());
        setUsername(userDto.getUsername());
        // setActive(true);
    }
}
