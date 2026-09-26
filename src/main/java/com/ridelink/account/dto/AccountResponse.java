package com.ridelink.account.dto;

import com.ridelink.account.entity.Account;
import com.ridelink.account.entity.AccountStatus;
import com.ridelink.account.entity.Role;

public class AccountResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private Role role;
    private AccountStatus status;

    public AccountResponse() {
    }

    public AccountResponse(Long id, String name, String email,
                           String phone, Role role, AccountStatus status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.status = status;
    }

    public static AccountResponse fromEntity(Account account) {
        return new AccountResponse(
                account.getId(),
                account.getName(),
                account.getEmail(),
                account.getPhone(),
                account.getRole(),
                account.getStatus()
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Role getRole() {
        return role;
    }

    public AccountStatus getStatus() {
        return status;
    }
}