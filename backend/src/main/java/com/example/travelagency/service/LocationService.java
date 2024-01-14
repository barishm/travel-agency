package com.example.travelagency.service;

import com.example.travelagency.entity.dtos.CreateLocationDTO;
import com.example.travelagency.entity.dtos.ResponseLocationDTO;
import com.example.travelagency.entity.dtos.UpdateLocationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {
    void deleteLocation(Long locationId);

    void updateLocation(UpdateLocationDTO updateLocationDTO);

    ResponseLocationDTO findLocationById(Long id);

    void createLocation(CreateLocationDTO createLocationDTO);

    List<ResponseLocationDTO> getAllLocations();
}
