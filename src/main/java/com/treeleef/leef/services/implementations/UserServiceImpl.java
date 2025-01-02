package com.treeleef.leef.services.implementations;

import com.treeleef.leef.dto.CreateUserDto;
import com.treeleef.leef.models.User;
import com.treeleef.leef.repositories.UserRepository;
import com.treeleef.leef.services.UserService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    // THIS IS A VALUE FOR TESTING, CHANGE THIS VALUE LATER ON
    private final BigDecimal INITIAL_BALANCE = BigDecimal.valueOf(200.0);

    public UserServiceImpl(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    public Optional<User> createUser(CreateUserDto createUserDto) {
        var user = User.builder()
                .username(createUserDto.getUsername())
                .balance(INITIAL_BALANCE)
                .build();
        userRepository.save(user);
        return Optional.of(user);
    }
}
