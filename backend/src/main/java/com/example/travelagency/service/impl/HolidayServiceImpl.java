package com.example.travelagency.service.impl;

import com.example.travelagency.entity.Holiday;
import com.example.travelagency.entity.Location;
import com.example.travelagency.entity.dtos.CreateHolidayDTO;
import com.example.travelagency.entity.dtos.ResponseHolidayDTO;
import com.example.travelagency.entity.dtos.ResponseLocationDTO;
import com.example.travelagency.entity.dtos.UpdateHolidayDTO;
import com.example.travelagency.repository.HolidayRepository;
import com.example.travelagency.repository.LocationRepository;
import com.example.travelagency.service.HolidayService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class HolidayServiceImpl implements HolidayService {
    private final HolidayRepository holidayRepository;
    private final LocationRepository locationRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public HolidayServiceImpl(HolidayRepository holidayRepository, LocationRepository locationRepository, ModelMapper modelMapper) {
        this.holidayRepository = holidayRepository;
        this.locationRepository = locationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void deleteHoliday(Long holidayId) {
        holidayRepository.deleteById(holidayId);
    }

    @Override
    public ResponseHolidayDTO findById(Long id) {
        Optional<Holiday> holidayOptional = holidayRepository.findById(id);

        return holidayOptional.map(holiday -> {
            ResponseHolidayDTO responseHolidayDTO = modelMapper.map(holiday, ResponseHolidayDTO.class);
            responseHolidayDTO.setLocation(modelMapper.map(holiday.getLocation(), ResponseLocationDTO.class));
            return responseHolidayDTO;
        }).orElse(null);
    }

    @Override
    public void updateHoliday(UpdateHolidayDTO updateHolidayDTO) {
        Holiday holidayToUpdate = modelMapper.map(updateHolidayDTO, Holiday.class);
        Location location;
        Optional<Location> optionalLocation = locationRepository.findById(updateHolidayDTO.getLocation());
        if(optionalLocation.isPresent()){
            location = optionalLocation.get();
            holidayToUpdate.setLocation(location);
        }
        System.out.println();
        holidayRepository.save(holidayToUpdate);
    }

    @Override
    public void createHoliday(CreateHolidayDTO createHolidayDTO) {
        Holiday newHoliday = modelMapper.map(createHolidayDTO, Holiday.class);
        Location location;
        Optional<Location> optionalLocation = locationRepository.findById(createHolidayDTO.getLocation());
        if(optionalLocation.isPresent()){
            location = optionalLocation.get();
            newHoliday.setLocation(location);
        }
        holidayRepository.save(newHoliday);
    }

    @Override
    public List<ResponseHolidayDTO> getAllHolidays() {
        List<Holiday> allHolidays = holidayRepository.findAll();

        return allHolidays.stream()
                .map(holiday -> modelMapper.map(holiday, ResponseHolidayDTO.class))
                .collect(Collectors.toList());
    }
}
