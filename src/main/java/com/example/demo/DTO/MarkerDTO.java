package com.example.demo.DTO;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class MarkerDTO {

    String name;

    double[] coords = new double[2];

    @QueryProjection
    public MarkerDTO(String name, double latitude, double longitude) {
        this.name = name;

        coords[0] = latitude;
        coords[1] = longitude;
    }

}
