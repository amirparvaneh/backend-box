package com.snapp.backend_box.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "delivery")
@EqualsAndHashCode(callSuper = false)
public class Delivery extends BaseEntity {
    private LocalDateTime deliveryDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "biker_id",nullable = false)
    private Biker biker;
    @OneToOne(mappedBy = "delivery",cascade = CascadeType.ALL)
    private Feedback feedback;
}
