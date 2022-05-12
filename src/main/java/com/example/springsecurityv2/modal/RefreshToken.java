package com.example.springsecurityv2.modal;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Data
public class RefreshToken extends IdBaseEntity implements Serializable {

    @OneToOne
    private User user;
    @Column(unique = true,nullable = false)
    private String token;
    @Column(nullable = false)
    private Instant expiryDate;
}
