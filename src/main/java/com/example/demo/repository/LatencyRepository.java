package com.example.demo.repository;

import com.example.demo.domain.Latency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LatencyRepository extends JpaRepository<Latency, Integer> {
}
