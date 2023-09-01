package com.novare.eika.services;

import com.novare.eika.models.Image;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ImageServiceInterface {
    public Image create(Image image);
    public List<Image> viewAll();
    public Image viewById(long id);
}
