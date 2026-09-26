package com.ridelink.account.dto;

import com.ridelink.account.entity.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RegisterRequest {

    @Schema(description = "Full name of the user", example = "Kamal Perera")
    @NotBlank(message = "Name is required")
    private String name;

    @Schema(description = "Unique email address", example = "kamal.perera@example.com")
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @Schema(description = "Account password", example = "Password123!")
    @NotBlank(message = "Password is required")
    private String password;

    @Schema(description = "Contact phone number", example = "+94771234567")
    @NotBlank(message = "Phone is required")
    private String phone;

    @Schema(description = "User role in system", example = "PASSENGER")
    @NotNull(message = "Role is required")
    private Role role;

    public RegisterRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}