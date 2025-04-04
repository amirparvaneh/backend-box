package com.snapp.backend_box.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "feedback")
@EqualsAndHashCode(callSuper = false)
public class Feedback extends BaseEntity{
    @Column(nullable = false,unique = true)
    private String code;
    @Column(nullable = false)
    private int rating;
    @Column(columnDefinition = "TEXT")
    private String comment;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
    private LocalDateTime submissionDate;
}
