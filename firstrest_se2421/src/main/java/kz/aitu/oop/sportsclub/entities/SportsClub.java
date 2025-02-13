package kz.aitu.oop.sportsclub.entities;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sports_clubs")
public class SportsClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clubName;

    @OneToMany(mappedBy = "sport", cascade = CascadeType.ALL)
    private List<Player> players;

    public SportsClub() {}

    public SportsClub(String clubName) {
        this.clubName = clubName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getClubName() { return clubName; }
    public void setClubName(String clubName) { this.clubName = clubName; }
    public List<Player> getPlayers() { return players; }
    public void setPlayers(List<Player> players) { this.players = players; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub that = (SportsClub) o;
        return Objects.equals(id, that.id) && Objects.equals(clubName, that.clubName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clubName);
    }

    @Override
    public String toString() {
        return "SportsClub{" + "id=" + id + ", clubName='" + clubName + '\'' + '}';
    }
}