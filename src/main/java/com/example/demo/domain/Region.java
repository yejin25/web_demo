package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "region")
@NoArgsConstructor
public class Region {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private double latitude;    //위도

    @Column
    private double longitude;   //경도

    @JsonIgnore
    @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "timestamp(6) default current_timestamp(6)")
    private LocalDateTime createDateTime;

    @Builder
    public Region(Integer id, String name, double latitude, double longitude, LocalDateTime localDateTime){
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createDateTime = localDateTime;
    }

}