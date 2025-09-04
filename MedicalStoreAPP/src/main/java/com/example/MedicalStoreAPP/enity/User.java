package com.example.MedicalStoreAPP.enity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String Email;
    private String Password;

    @Enumerated(EnumType.STRING)
    private Role role;
    public enum Role {
        ADMIN, STAFF
    }
    public User(){}

    public User(String username,String Email,String Password,Role role)
    {
        this.username = username;
        this.Email = Email;
        this.Password = Password;
        this.role = role;
    }
    public long getId()
    {
        return id;
    }
    public void setId(long id)
    {
        this.id=id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        this.Password = Password;
    }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

}
