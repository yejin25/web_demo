package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name = "latency")
@NoArgsConstructor
public class Latency {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String region;

    @Column
    private float latency;

    @JsonIgnore
    @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "timestamp(6) default current_timestamp(6)")
    private LocalDateTime createDateTime;

    @Builder
    public Latency(Integer id, String region, float latency, LocalDateTime localDateTime){
        this.id = id;
        this.region = region;
        this.latency = latency;
        this.createDateTime = localDateTime;
    }

}
