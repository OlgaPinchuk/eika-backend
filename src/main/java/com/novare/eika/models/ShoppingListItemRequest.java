package com.novare.eika.models;

import org.springframework.web.multipart.MultipartFile;

public class ShoppingListItemRequest {
    private String title;
    private double price;
    private MultipartFile image;

    public ShoppingListItemRequest(String title, double price, MultipartFile image) {
        this.title = title;
        this.price = price;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
