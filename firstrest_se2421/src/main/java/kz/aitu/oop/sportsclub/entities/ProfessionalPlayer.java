package kz.aitu.oop.sportsclub.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PROFESSIONAL")
public class ProfessionalPlayer extends Player {
    private double salary;

    public ProfessionalPlayer() {}

    public ProfessionalPlayer(String name, int age, Sport sport, double salary) {
        super(name, age, sport);
        this.salary = salary;
    }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}