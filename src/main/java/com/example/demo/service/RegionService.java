package com.example.demo.service;


import com.example.demo.DTO.MarkerDTO;
import com.example.demo.repository.RegionRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RegionService {

    @NonNull
    private final RegionRepository regionRepository;


    public List<MarkerDTO> findValueForMarker(){
        return regionRepository.findValueForMarker();
    }

    public List<String> findRGWithoutCurrentRG(String regionName) {return regionRepository.findRGWithoutCurrentRG(regionName);}

    public List<String> findAllRegionName(){ return regionRepository.findAllRegionName();}
}
