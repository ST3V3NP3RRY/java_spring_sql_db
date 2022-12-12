package com.example.pirateservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pirates")
public class Pirate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name ="age")
    private int age;

    @ManyToOne
    @JoinColumn(name="ship_id", nullable=false)
    @JsonIgnoreProperties({"pirates"})
    private Ship ship;

    @ManyToMany
    @JsonIgnoreProperties({"pirates"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "pirates_raids",
            joinColumns = { @JoinColumn(
                    name = "pirate_id",
                    nullable = false,
                    updatable = false)
            },
            inverseJoinColumns = { @JoinColumn(
                    name = "raid_id",
                    nullable = false,
                    updatable = false)
            }
    )
    private List<Raid> raids;

    public Pirate(String firstName, String lastName, int age, Ship ship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ship = ship;
        this.raids = new ArrayList<>();
    }

    public Pirate() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
