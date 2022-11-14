package com.example.demo.repository;

import com.example.demo.domain.Region;
import com.example.demo.repository.custom.CustomRegionRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Integer>, CustomRegionRepository {
}
