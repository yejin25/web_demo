package com.example.demo.repository;

import com.example.demo.domain.Latency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LatencyRepository extends JpaRepository<Latency, Integer> {
    public float findByRegion(String region);
}
