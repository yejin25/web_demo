package com.example.demo.service;

import com.example.demo.domain.Latency;
import com.example.demo.repository.LatencyRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class LatencyService {
    @NonNull
    private final LatencyRepository latencyRepository;

    public float findLatencyByRegion(String region){
        return latencyRepository.findByRegion(region);
    }

    @Transactional
    public Latency save(Latency latency){
        return latencyRepository.save(latency);
    }
}
