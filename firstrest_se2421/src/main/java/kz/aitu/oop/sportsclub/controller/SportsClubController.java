package kz.aitu.oop.sportsclub.controller;

import kz.aitu.oop.sportsclub.entities.SportsClub;
import kz.aitu.oop.sportsclub.entities.Player;
import kz.aitu.oop.sportsclub.repository.SportsClubRepository;
import kz.aitu.oop.sportsclub.repository.PlayerRepository;
import kz.aitu.oop.sportsclub.repository.SportRepository;
import kz.aitu.oop.sportsclub.exceptions.PlayerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sportsclub")
public class SportsClubController {
    @Autowired
    private SportsClubRepository sportsClubRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private SportRepository sportRepository;

    @GetMapping("/clubs")
    public List<SportsClub> getAllClubs() {
        return sportsClubRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<SportsClub> addClub(@RequestBody SportsClub club) {
        return ResponseEntity.ok(sportsClubRepository.save(club));
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Optional<Player> player = playerRepository.findById(id);
        return player.map(ResponseEntity::ok).orElseThrow(() -> new PlayerNotFoundException("Player not found with ID: " + id));
    }

    @PostMapping("/addPlayer")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player savedPlayer = playerRepository.save(player);
        return ResponseEntity.ok(savedPlayer);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteClub(@PathVariable Long id) {
        if (!sportsClubRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        sportsClubRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<String> handlePlayerNotFoundException(PlayerNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
