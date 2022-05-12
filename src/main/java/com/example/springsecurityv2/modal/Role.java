package com.example.springsecurityv2.modal;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Data
@Entity
public class Role extends IdBaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

}
