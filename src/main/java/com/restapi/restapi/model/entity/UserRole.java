package com.restapi.restapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

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

    @CreationTimestamp
    private Date inserttime;
    @Column(name = "updatetime")
    @UpdateTimestamp
    private Date updatetime;

    public UserRole(int id, String name, String permissions, String status, float level) {
        this.id = id;
        this.name = name;
        this.permissions = permissions;
        this.status = status;
        this.level = level;
    }
}
