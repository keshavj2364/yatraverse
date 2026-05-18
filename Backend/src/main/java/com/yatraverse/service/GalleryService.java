package com.yatraverse.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import com.yatraverse.entity.GalleryImage;
import com.yatraverse.repository.GalleryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class GalleryService {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private GalleryRepository galleryRepository;

    public GalleryImage uploadImage(
            MultipartFile file,
            String title,
            String email)
            throws Exception {

        Map uploadResult = cloudinary.uploader()
        .upload(
            file.getBytes(),
            ObjectUtils.emptyMap()
        );

        String imageUrl =
        uploadResult.get("url").toString();

        GalleryImage image =
        new GalleryImage();

        image.setImageUrl(imageUrl);

        image.setTitle(title);

        image.setUserEmail(email);

        return galleryRepository.save(image);
    }

    public List<GalleryImage>
    getUserImages(String email) {

        return galleryRepository
        .findByUserEmail(email);
    }
}