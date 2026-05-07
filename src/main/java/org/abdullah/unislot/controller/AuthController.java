package org.abdullah.unislot.controller;

import org.abdullah.unislot.dto.LoginRequest;
import org.abdullah.unislot.dto.LoginResponse;
import org.abdullah.unislot.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request.email, request.password);
    }
}