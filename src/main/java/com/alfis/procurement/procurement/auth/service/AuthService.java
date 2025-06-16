package com.example.procurement.auth.service;

import com.example.procurement.auth.dto.AuthRequest;
import com.example.procurement.auth.dto.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest request);
}
