package com.example.travelagency.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer duration;

    @Column(name = "free_slots")
    private Integer freeSlots;

    @Column
    private String price;

    @Column
    private String title;

    @Column
    private Date startDate;

    @ManyToOne
    private Location location;

    @OneToMany(mappedBy = "holiday", cascade = CascadeType.REMOVE)
    private List<Reservation> reservations;
}
