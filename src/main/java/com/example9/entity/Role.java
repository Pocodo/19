package com.example9.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_id;
    @Column
    private String name;

}
