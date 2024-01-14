package com.example.travelagency.service.impl;

import com.example.travelagency.entity.Holiday;
import com.example.travelagency.entity.Reservation;
import com.example.travelagency.entity.dtos.CreateReservationDTO;
import com.example.travelagency.entity.dtos.ResponseReservationDTO;
import com.example.travelagency.entity.dtos.UpdateReservationDTO;
import com.example.travelagency.repository.HolidayRepository;
import com.example.travelagency.repository.ReservationRepository;
import com.example.travelagency.service.ReservationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final HolidayRepository holidayRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public ReservationServiceImpl(ReservationRepository reservationRepository, HolidayRepository holidayRepository, ModelMapper modelMapper) {
        this.reservationRepository = reservationRepository;
        this.holidayRepository = holidayRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public void createReservation(CreateReservationDTO createReservationDTO) {
        Reservation newReservation = modelMapper.map(createReservationDTO, Reservation.class);
        Holiday holiday;
        Optional<Holiday> optionalHoliday = holidayRepository.findById(createReservationDTO.getHoliday());
        if(optionalHoliday.isPresent()){
            holiday = optionalHoliday.get();
            holiday.setFreeSlots(holiday.getFreeSlots() - 1);
            newReservation.setHoliday(holiday);
        }
        reservationRepository.save(newReservation);
    }

    @Override
    public void updateReservation(UpdateReservationDTO updateReservationDTO) {
        Reservation reservationToUpdate = modelMapper.map(updateReservationDTO, Reservation.class);
        Holiday holiday;
        Optional<Holiday> optionalHoliday = holidayRepository.findById(updateReservationDTO.getId());
        if(optionalHoliday.isPresent()){
            holiday = optionalHoliday.get();
            reservationToUpdate.setHoliday(holiday);
        }
        reservationRepository.save(reservationToUpdate);
    }

    @Override
    public ResponseReservationDTO findReservationById(Long reservationId) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(reservationId);
        return reservationOptional.map(reservation -> modelMapper.map(reservation, ResponseReservationDTO.class)).orElse(null);
    }

    @Override
    public List<ResponseReservationDTO> getAllReservations() {
        List<Reservation> allReservations = reservationRepository.findAll();

        return allReservations.stream()
                .map(reservation -> modelMapper.map(reservation, ResponseReservationDTO.class))
                .collect(Collectors.toList());
    }
}
