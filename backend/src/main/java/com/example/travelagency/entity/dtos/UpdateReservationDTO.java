package com.example.travelagency.entity.dtos;

import lombok.Data;

@Data
public class UpdateReservationDTO {
    private Long id;
    private String contactName;
    private String phoneNumber;
    private Long holiday;
}
