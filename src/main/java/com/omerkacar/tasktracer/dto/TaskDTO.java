package com.omerkacar.tasktracer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskDTO {
    private Long id;

    @NotBlank(message = "Başlık boş olamaz")
    @Size(min = 3, message = "Başlık en az 3 karakter olmalı")
    private String title;

    private String description;
    private boolean completed;

    // Getter ve Setter metotlarını ekle (Generate -> Getter and Setter)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}