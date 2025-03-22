package com.snapp.backend_box.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at",nullable = false,updatable = false)
    private LocalDateTime created;
    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updated;


    @PrePersist
    protected void onCreate() {
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated = LocalDateTime.now();
    }
}
