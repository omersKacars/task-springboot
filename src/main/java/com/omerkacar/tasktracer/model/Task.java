package com.omerkacar.tasktracer.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity // Bu sınıfın bir veritabanı tablosu olduğunu belirtir
@Table(name = "tasks") // Veritabanındaki tablo adını belirler
public class Task {

    @Id // Birincil anahtar (Primary Key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan (auto-increment)
    private Long id;

    @Column(nullable = false) // Boş geçilemez

    @NotBlank(message = "Görev başlığı boş bırakılamaz")
    @Size(min = 3, max = 100, message = "Başlık en az 3, en fazla 100 karakter olmalıdır")
    private String title;

    @NotBlank(message = "Açıklama alanı boş bırakılamaz")
    private String description;



    private boolean completed = false;

    // --- Getter ve Setter Metotları ---
    // (Eğitmen olduğun için buraları biliyorsun,
    // sağ tık -> Generate -> Getter and Setter diyerek hepsini ekle)

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