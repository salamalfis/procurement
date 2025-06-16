package com.alfis.procurement.user.service;

import com.alfis.procurement.user.dto.*;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponseDTO createUser(UserCreateDTO dto);
    List<UserResponseDTO> getAllUsers();
    void deleteUser(UUID id);
    UserResponseDTO getCurrentUser();
}
