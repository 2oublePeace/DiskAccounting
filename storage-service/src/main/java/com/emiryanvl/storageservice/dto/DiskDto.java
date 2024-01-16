package com.emiryanvl.storageservice.dto;
public class DiskDto {
    private String title;
    private boolean isRented = false;
    DiskDto(String title, Boolean isRented) {
        this.title = title;
        this.isRented = isRented;
    }

    public Boolean getRented() {
        return isRented;
    }

    public void setRented(Boolean rented) {
        isRented = rented;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
