package com.example9.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    @Column
    private String username;
    @Column
    private String password;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="UserRole",joinColumns = @JoinColumn(name="user_id",referencedColumnName = "user_id")
            ,inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "role_id"))
    private Set<Role> roles = new HashSet<>();
}
