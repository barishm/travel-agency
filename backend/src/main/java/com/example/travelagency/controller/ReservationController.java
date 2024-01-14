package com.example.travelagency.controller;

import com.example.travelagency.entity.dtos.CreateReservationDTO;
import com.example.travelagency.entity.dtos.ResponseReservationDTO;
import com.example.travelagency.entity.dtos.UpdateReservationDTO;
import com.example.travelagency.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<ResponseReservationDTO> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public ResponseReservationDTO getReservationById(@PathVariable("id") Long id){
        return reservationService.findReservationById(id);
    }

    @PostMapping
    public void createReservation(@RequestBody CreateReservationDTO createReservationDTO) {
        reservationService.createReservation(createReservationDTO);
    }

    @PutMapping
    public void updateReservation(@RequestBody UpdateReservationDTO updateReservationDTO) {
        reservationService.updateReservation(updateReservationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteReservationById(@PathVariable("id")Long id){
        reservationService.deleteReservation(id);
    }


}
