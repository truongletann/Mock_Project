package com.mock.dto;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailDTO extends User implements UserDetails {
    private int user_id;
    private String email;
    private String avatar;
    private String full_name;



    private static final long serialVersionUID = 1L;

    public UserDetailDTO(int user_id, String email, String password, String avatar, String full_name, Collection<? extends GrantedAuthority> authorities) {
        super(email, password, authorities);
        this.email = email;
        this.avatar = avatar;
        this.user_id = user_id;
        this.full_name = full_name;

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
