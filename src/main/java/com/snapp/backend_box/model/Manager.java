package com.snapp.backend_box.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "manager")
@EqualsAndHashCode(callSuper = false)
public class Manager extends BaseEntity{
    private String firstName;
    private String lastName;
    @Column(nullable = false,unique = true)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role = "ROLE_MANAGER";
}
