package com.example.demo.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Coordinate {

    JP(35.6894,139.692),
    SG( 1.28333, 103.85),
    CA(	56.13, -106.35),
    US(43.8041334, -120.5542012),
    GB(51.5072, -0.1275);
    
    private double latitude;
    private double longitude;
}
