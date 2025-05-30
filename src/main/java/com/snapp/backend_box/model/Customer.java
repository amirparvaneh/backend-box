package com.snapp.backend_box.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "customer")
@EqualsAndHashCode(callSuper = false)
public class Customer extends BaseEntity {
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Delivery> deliveries = new ArrayList<>();
    @Column(nullable = false)
    private String password;
}
