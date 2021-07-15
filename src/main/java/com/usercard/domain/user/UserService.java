package com.usercard.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Long create(UserEntity user) {
        UserEntity createdUser = userRepository.save(user);
        return createdUser.getId();
    }
}
