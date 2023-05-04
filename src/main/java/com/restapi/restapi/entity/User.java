package com.restapi.restapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @JsonIgnore
    private String username;

    @Column(name = "password")
    @JsonIgnore
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
    @JsonIgnore
    private String attributes;

    @Column(name = "inserttime")
    @JsonIgnore
    private int inserttime;

    @Column(name = "updatetime")
    @JsonIgnore
    private int updatetime;

    /*
    if you wanna get user and his/her role(s)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<UserRole> userRoles;
    */


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
