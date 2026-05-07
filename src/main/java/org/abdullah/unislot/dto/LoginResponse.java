package org.abdullah.unislot.dto;

public class LoginResponse {

    private String role;
    private Integer personelId;

    public LoginResponse(String role, Integer personelId) {
        this.role = role;
        this.personelId = personelId;
    }

    public String getRole() {
        return role;
    }

    public Integer getPersonelId() {
        return personelId;
    }
}