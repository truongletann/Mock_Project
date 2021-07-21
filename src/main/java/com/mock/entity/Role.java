package com.mock.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id
    private String role_id;
    private String role_name;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> user;

    public Role() {
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
