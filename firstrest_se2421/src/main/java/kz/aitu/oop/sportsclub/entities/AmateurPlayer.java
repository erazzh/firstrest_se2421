package kz.aitu.oop.sportsclub.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("AMATEUR")
public class AmateurPlayer extends Player {
    private String clubName;

    public AmateurPlayer() {}

    public AmateurPlayer(String name, int age, Sport sport, String clubName) {
        super(name, age, sport);
        this.clubName = clubName;
    }

    public String getClubName() { return clubName; }
    public void setClubName(String clubName) { this.clubName = clubName; }
}