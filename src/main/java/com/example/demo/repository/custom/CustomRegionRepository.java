package com.example.demo.repository.custom;

import com.example.demo.DTO.MarkerDTO;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Map;

@NoRepositoryBean
public interface CustomRegionRepository {
    List<MarkerDTO> findValueForMarker();

    List<String> findRGWithoutCurrentRG(String regionName);
}