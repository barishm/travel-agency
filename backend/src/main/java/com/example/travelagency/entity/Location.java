package com.example.travelagency.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String number;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String street;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "location", cascade = CascadeType.REMOVE)
    private List<Holiday> holidays;
}
