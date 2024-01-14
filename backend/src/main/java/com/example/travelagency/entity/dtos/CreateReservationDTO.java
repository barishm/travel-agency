package com.example.travelagency.entity.dtos;

import lombok.Data;

@Data
public class CreateReservationDTO {
    private String contactName;

    private String phoneNumber;

    private Long holiday;
}
