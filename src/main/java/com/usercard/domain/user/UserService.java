package com.usercard.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Long create(UserEntity user) {
        UserEntity createdUser = userRepository.save(user);
        return createdUser.getId();
    }

    public UserEntity update(UserEntity user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public UserEntity get(Long id) {
        return userRepository.getById(id);
    }

    public List<UserEntity> get(String name, String phoneNumber) {
        return userRepository.findAll(UserSpecification.getSpecification(name, phoneNumber));
    }
}
