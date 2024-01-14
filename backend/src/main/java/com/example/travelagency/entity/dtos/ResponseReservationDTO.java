package com.example.travelagency.entity.dtos;

import lombok.Data;

@Data
public class ResponseReservationDTO {
    private Long id;

    private String contactName;

    private String phoneNumber;

    private ResponseHolidayDTO holiday;
}
