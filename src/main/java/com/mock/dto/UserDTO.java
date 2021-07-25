package com.mock.dto;

public class UserDTO {

    private int user_id;
    private String email;
    private String full_name;
    private String password;
    private String avatar;
    private int phone;
    private String address;
    private boolean status;
    private String role_id;
    private String role_name;

    public UserDTO() {
    }

    public UserDTO(int user_id, String email, String full_name, String password, String avatar, int phone, String address, boolean status, String role_id, String role_name) {
        this.user_id = user_id;
        this.email = email;
        this.full_name = full_name;
        this.password = password;
        this.avatar = avatar;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.role_id = role_id;
        this.role_name = role_name;
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

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
