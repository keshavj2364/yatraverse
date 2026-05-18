package com.yatraverse.repository;

import com.yatraverse.entity.GalleryImage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GalleryRepository
extends JpaRepository<GalleryImage, Long> {

    List<GalleryImage>
    findByUserEmail(String userEmail);
}