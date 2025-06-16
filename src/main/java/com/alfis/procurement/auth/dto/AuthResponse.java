package com.alfis.procurement.auth.dto;

public record AuthResponse(String token, String role, String email) {}
