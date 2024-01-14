package com.example.travelagency.entity.dtos;

import lombok.Data;

import java.util.Date;
@Data
public class UpdateHolidayDTO {
    private Long id;
    private Long location;
    private String title;
    private Date startDate;

    private Integer duration;
    private String price;
    private Integer freeSlots;
}
