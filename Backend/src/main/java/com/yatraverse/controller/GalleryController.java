package com.yatraverse.controller;

import com.yatraverse.entity.GalleryImage;
import com.yatraverse.service.GalleryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/gallery")
@CrossOrigin("*")
public class GalleryController {

    @Autowired
    private GalleryService galleryService;

    @PostMapping
    public GalleryImage uploadImage(

        @RequestParam("file")
        MultipartFile file,

        @RequestParam("title")
        String title,

        @RequestParam("email")
        String email

    ) throws Exception {

        return galleryService
        .uploadImage(
            file,
            title,
            email
        );
    }

    @GetMapping("/{email}")
    public List<GalleryImage>
    getImages(
        @PathVariable String email
    ) {

        return galleryService
        .getUserImages(email);
    }
}