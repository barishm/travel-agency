package com.example.travelagency.service;
import com.example.travelagency.entity.dtos.CreateHolidayDTO;
import com.example.travelagency.entity.dtos.ResponseHolidayDTO;
import com.example.travelagency.entity.dtos.UpdateHolidayDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HolidayService {
    void deleteHoliday(Long holidayId);

    ResponseHolidayDTO findById(Long id);

    void updateHoliday(UpdateHolidayDTO updateHolidayDTO);

    void createHoliday(CreateHolidayDTO createHolidayDTO);

    List<ResponseHolidayDTO> getAllHolidays();


}
