package com.yatraverse.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;
}