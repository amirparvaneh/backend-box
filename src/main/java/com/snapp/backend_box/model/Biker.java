package com.snapp.backend_box.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "biker")
public class Biker extends BaseEntity{
    private String firstName;
    private String lastName;
    @Column(nullable = false,unique = true)
    private String email;
    private Integer averageRating;
    @OneToMany(mappedBy = "biker",cascade = CascadeType.ALL)
    private List<Delivery> deliveries = new ArrayList<>();
}
