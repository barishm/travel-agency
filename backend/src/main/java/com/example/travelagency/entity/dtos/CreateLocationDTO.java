package com.example.travelagency.entity.dtos;

import lombok.Data;

@Data
public class CreateLocationDTO {
    private String street;

    private String number;

    private String city;

    private String country;

    private String imageUrl;

}
