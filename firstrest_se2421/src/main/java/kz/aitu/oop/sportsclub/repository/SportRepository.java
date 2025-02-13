package kz.aitu.oop.sportsclub.repository;

import kz.aitu.oop.sportsclub.entities.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {}