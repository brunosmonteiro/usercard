package com.usercard.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public List<UserDto> get(
        @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
        @RequestParam(value = "name", required = false) String name
    ) {
        return userService.get(name, phoneNumber)
            .stream()
            .map(userMapper::toUserDto)
            .collect(Collectors.toList());
    }

    public UserDto get(@PathVariable("/{id}") Long id) {

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(UserDto request) {
        return userService.create(userMapper.toUserEntity(request));
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable("id") Long id, @RequestBody UserDto request) {
        request.setId(id);
        return userMapper.toUserDto(userService.update(userMapper.toUserEntity(request)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    //TODO: create card operations
}
