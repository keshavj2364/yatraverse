package com.yatraverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yatraverse.entity.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

}