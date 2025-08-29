package com.booleanuk.api.controller;

import com.booleanuk.api.dto.GameDto;
import com.booleanuk.api.model.Game;
import com.booleanuk.api.repository.GameRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("games")
public class GameController {
    private final GameRepository repository;

    public GameController(GameRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping
    public ResponseEntity<List<Game>> getAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Game> getById(@PathVariable("id") Integer id) {
        Optional<Game> game = this.repository.findById(id);
        return game.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Game> create(@RequestBody GameDto gameDto) {
        Game game = new Game(gameDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.repository.save(game));
    }

    @PutMapping("{id}")
    public ResponseEntity<Game> update(@PathVariable("id") Integer id, @RequestBody GameDto gameDto) {
        Optional<Game> optionalGame = this.repository.findById(id);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            game.setTitle(gameDto.getTitle());
            game.setPublisher(gameDto.getPublisher());
            game.setDeveloper(gameDto.getDeveloper());
            game.setReleaseYear(gameDto.getReleaseYear());
            game.setEarlyAccess(gameDto.isEarlyAccess());
            return ResponseEntity.ok(this.repository.save(game));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Game> delete(@PathVariable("id") Integer id) {
        Optional<Game> optionalGame = this.repository.findById(id);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            this.repository.deleteById(id);
            return ResponseEntity.ok(game);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}