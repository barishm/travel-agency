package com.example.travelagency.controller;

import com.example.travelagency.entity.dtos.CreateHolidayDTO;
import com.example.travelagency.entity.dtos.ResponseHolidayDTO;
import com.example.travelagency.entity.dtos.UpdateHolidayDTO;
import com.example.travelagency.service.HolidayService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/holidays")
public class HolidayController {
    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping
    public List<ResponseHolidayDTO> getAllHolidays() {
        return holidayService.getAllHolidays();
    }

    @GetMapping("/{id}")
    public ResponseHolidayDTO getHolidayById(@PathVariable("id")Long id){
        return holidayService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteHolidayById(@PathVariable("id") Long id){
        holidayService.deleteHoliday(id);
    }

    @PutMapping
    public void updateHoliday(@RequestBody UpdateHolidayDTO updateHolidayDTO) {
        holidayService.updateHoliday(updateHolidayDTO);
    }

    @PostMapping
    public void createHoliday(@RequestBody CreateHolidayDTO createHolidayDTO){
        holidayService.createHoliday(createHolidayDTO);
    }


}
