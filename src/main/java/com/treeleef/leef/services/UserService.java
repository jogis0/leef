package com.treeleef.leef.services;

import com.treeleef.leef.dto.CreateUserDto;
import com.treeleef.leef.models.User;

import java.util.Optional;

public interface UserService {
    Optional<User> createUser(CreateUserDto createUserDto);
}
