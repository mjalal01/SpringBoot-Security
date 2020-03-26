package com.mehdiyevcs.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="users")
public @Data
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String role;
}
