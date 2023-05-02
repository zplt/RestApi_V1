package com.restapi.restapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_roles")
@Data
@NoArgsConstructor
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "permissions")
    private String permissions;
    @Column(name = "status")
    private String status;
    @Column(name = "level")
    private float level;
    @Column(name = "inserttime")
    private int inserttime;
    @Column(name = "updatetime")
    private int updatetime;

    public UserRole(String name, String permissions, String status, float level, int inserttime, int updatetime) {
        this.name = name;
        this.permissions = permissions;
        this.status = status;
        this.level = level;
        this.inserttime = inserttime;
        this.updatetime = updatetime;
    }
}
