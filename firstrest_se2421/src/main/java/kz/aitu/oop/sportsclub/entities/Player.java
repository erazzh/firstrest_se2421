package kz.aitu.oop.sportsclub.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "player_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "players")
public abstract class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    @ManyToOne
    @JoinColumn(name = "sport_id")
    private Sport sport;

    public Player() {}

    public Player(String name, int age, Sport sport) {
        this.name = name;
        this.age = age;
        this.sport = sport;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public Sport getSport() { return sport; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setSport(Sport sport) { this.sport = sport; }
}