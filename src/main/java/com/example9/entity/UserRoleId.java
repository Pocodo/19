package com.example9.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;


@Embeddable

public class UserRoleId implements Serializable {
    @Column
    private Integer user_id;
    @Column
    private Integer role_id;
}

