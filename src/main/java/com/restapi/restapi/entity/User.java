package com.restapi.restapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "h_no")
    private String h_no;

    @Column(name = "sicil_no")
    private int sicil_no;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "role_id")
    private int role_id;

    @Column(name = "status")
    private String status;

    @Column(name = "attributes")
    private String attributes;

    @Column(name = "inserttime")
    private int inserttime;

    @Column(name = "updatetime")
    private int updatetime;

    public User(String h_no, int sicil_no, String username, String password, String firstname, String lastname, int role_id, String status, String attributes, int inserttime, int updatetime) {
        this.h_no = h_no;
        this.sicil_no = sicil_no;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role_id = role_id;
        this.status = status;
        this.attributes = attributes;
        this.inserttime = inserttime;
        this.updatetime = updatetime;
    }
}
