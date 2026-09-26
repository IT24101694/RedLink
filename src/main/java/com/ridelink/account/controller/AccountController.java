package com.ridelink.account.controller;

import com.ridelink.account.dto.AccountResponse;
import com.ridelink.account.dto.RegisterRequest;
import com.ridelink.account.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication & Accounts", description = "Endpoints for user registration and authentication management")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Operation(summary = "Register a new user account", description = "Creates a new PASSENGER, DRIVER, or ADMIN account in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Account created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AccountResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input or validation failure", content = @Content),
            @ApiResponse(responseCode = "500", description = "Email already registered or internal error", content = @Content)
    })
    @PostMapping("/register")
    public ResponseEntity<AccountResponse> register(
            @Valid @RequestBody RegisterRequest request) {

        AccountResponse response = accountService.register(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}