package com.example.travelagency.entity.dtos;

import lombok.Data;

@Data
public class ResponseLocationDTO {
    private Long id;

    private String street;

    private String number;

    private String city;

    private String country;

    private String imageUrl;
}
