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
@Table(name = "biker")
@EqualsAndHashCode(callSuper = false)
public class Biker extends BaseEntity{
    private String firstName;
    private String lastName;
    @Column(nullable = false,unique = true)
    private String email;
    private Integer averageRating;
    @Column(nullable = false)
    private String role = "ROLE_BIKER";
    private String password;
    @OneToMany(mappedBy = "biker",cascade = CascadeType.ALL)
    @Builder.Default
    private List<Delivery> deliveries = new ArrayList<>();
}
