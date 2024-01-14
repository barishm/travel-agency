package com.example.travelagency.service.impl;

import com.example.travelagency.entity.Location;
import com.example.travelagency.entity.dtos.CreateLocationDTO;
import com.example.travelagency.entity.dtos.ResponseLocationDTO;
import com.example.travelagency.entity.dtos.UpdateLocationDTO;
import com.example.travelagency.repository.LocationRepository;
import com.example.travelagency.service.LocationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public LocationServiceImpl(LocationRepository locationRepository, ModelMapper modelMapper) {
        this.locationRepository = locationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void deleteLocation(Long locationId) {
        locationRepository.deleteById(locationId);
    }

    @Override
    public void updateLocation(UpdateLocationDTO updateLocationDTO) {
        Location location = modelMapper.map(updateLocationDTO, Location.class);
        locationRepository.save(location);
    }

    @Override
    public ResponseLocationDTO findLocationById(Long id) {
        Optional<Location> locationOptional = locationRepository.findById(id);
        return locationOptional.map(location -> modelMapper.map(location, ResponseLocationDTO.class)).orElse(null);

    }

    @Override
    public void createLocation(CreateLocationDTO createLocationDTO) {
        Location location = modelMapper.map(createLocationDTO, Location.class);
        locationRepository.save(location);
    }

    @Override
    public List<ResponseLocationDTO> getAllLocations() {
        List<Location> allLocations = locationRepository.findAll();

        return allLocations.stream()
                .map(location -> modelMapper.map(location, ResponseLocationDTO.class))
                .collect(Collectors.toList());
    }

}
