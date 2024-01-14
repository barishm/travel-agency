package com.example.travelagency.controller;

import com.example.travelagency.entity.dtos.CreateLocationDTO;
import com.example.travelagency.entity.dtos.ResponseLocationDTO;
import com.example.travelagency.entity.dtos.UpdateLocationDTO;
import com.example.travelagency.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<ResponseLocationDTO> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/{id}")
    public ResponseLocationDTO getLocationById(@PathVariable("id")Long id){
        return locationService.findLocationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLocationById(@PathVariable("id") Long id){
        locationService.deleteLocation(id);
    }

    @PostMapping
    public void createLocation(@RequestBody CreateLocationDTO createLocationDTO){
        locationService.createLocation(createLocationDTO);
    }

    @PutMapping
    public void updateLocation(@RequestBody UpdateLocationDTO updateLocationDTO){
        locationService.updateLocation(updateLocationDTO);
    }
}
