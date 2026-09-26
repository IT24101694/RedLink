package com.ridelink.account.service;

import com.ridelink.account.dto.AccountResponse;
import com.ridelink.account.dto.RegisterRequest;
import com.ridelink.account.entity.Account;
import com.ridelink.account.entity.AccountStatus;
import com.ridelink.account.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public AccountService(AccountRepository accountRepository,
                          PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AccountResponse register(RegisterRequest request) {

        // 1. Check whether email already exists
        if (accountRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        // 2. Create new account
        Account account = new Account();

        account.setName(request.getName());
        account.setEmail(request.getEmail());

        // 3. Hash the password
        account.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        account.setPhone(request.getPhone());

        // 4. Set role
        account.setRole(request.getRole());

        // 5. New account is ACTIVE
        account.setStatus(AccountStatus.ACTIVE);

        // 6. Save to MySQL
        Account savedAccount = accountRepository.save(account);

        // 7. Return safe response
        return AccountResponse.fromEntity(savedAccount);
    }
}