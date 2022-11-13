package com.example.demo.repository.support;

import com.example.demo.DTO.MarkerDTO;
import com.example.demo.DTO.QMarkerDTO;
import com.example.demo.domain.QRegion;
import com.example.demo.domain.Region;
import com.example.demo.repository.custom.CustomRegionRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.Map;

public class RegionRepositoryImpl extends QuerydslRepositorySupport implements CustomRegionRepository {
    private final QRegion region = QRegion.region;

    public RegionRepositoryImpl(){
        super(Region.class);
    }

    @Override
    public List<MarkerDTO> findValueForMarker() {
        return from(region).select(new QMarkerDTO(region.name, region.latitude, region.longitude)).fetch();
    }

    @Override
    public List<String> findRGWithoutCurrentRG(String regionName) {
        return from(region).select(region.name).where(region.name.notIn(regionName)).fetch();
    }


}
