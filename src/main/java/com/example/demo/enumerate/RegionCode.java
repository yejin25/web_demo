package com.example.demo.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RegionCode {

    Tokyo("JP"),
    Singapore("SG"),
    Canada("CA"),
    Oregon("US"),
    London("GB");

    private String region;

}
