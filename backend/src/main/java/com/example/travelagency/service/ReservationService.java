package com.example.travelagency.service;

import com.example.travelagency.entity.dtos.CreateReservationDTO;
import com.example.travelagency.entity.dtos.ResponseReservationDTO;
import com.example.travelagency.entity.dtos.UpdateReservationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {
    void deleteReservation(Long reservationId);

    void createReservation(CreateReservationDTO createReservationDTO);

    void updateReservation(UpdateReservationDTO updateReservationDTO);

    ResponseReservationDTO findReservationById(Long reservationId);

    List<ResponseReservationDTO> getAllReservations();
}
