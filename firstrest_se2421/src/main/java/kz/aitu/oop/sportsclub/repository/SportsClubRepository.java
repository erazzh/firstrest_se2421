package kz.aitu.oop.sportsclub.repository;

import kz.aitu.oop.sportsclub.entities.SportsClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportsClubRepository extends JpaRepository<SportsClub, Long> {}
