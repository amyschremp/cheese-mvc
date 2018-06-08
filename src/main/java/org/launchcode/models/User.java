package org.launchcode.models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.sun.tools.doclint.Entity.and;

public class User {

    @NotNull
    @Size(min=5, max=15)
    private String username;

    @Email
    private String email;

    @NotNull
    @Size(min=6, message = "size must be at least 6 characters")
    private String password;

    @NotNull(message = "Passwords do not match.")
    private String verifyPassword;

    private int userId;
    private static int nextId = 1;

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
        userId = nextId;
        nextId++;
    }

    private void checkPassword() {
        if (this.password != null || this.verifyPassword != null) {
            if (!this.password.equals(this.verifyPassword)) {
                this.verifyPassword = null;
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }
}
