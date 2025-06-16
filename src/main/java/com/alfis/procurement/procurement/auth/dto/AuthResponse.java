package com.example.procurement.auth.dto;

public record AuthResponse(String token, String role, String email) {}
