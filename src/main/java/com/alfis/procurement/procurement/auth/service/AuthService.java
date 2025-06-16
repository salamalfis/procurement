package com.alfis.procurement.auth.service;

import com.alfis.procurement.auth.dto.AuthRequest;
import com.alfis.procurement.auth.dto.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest request);
}
