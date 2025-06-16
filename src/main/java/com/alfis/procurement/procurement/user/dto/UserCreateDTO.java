package com.alfis.procurement.user.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserCreateDTO {
    private String email;
    private String password;
    private String fullName;
    private UUID roleId;
}
