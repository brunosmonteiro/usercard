package com.usercard.domain.user;

import com.usercard.domain.card.CardDto;
import com.usercard.domain.card.CardFlag;
import com.usercard.domain.card.CardMapper;
import com.usercard.domain.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CardMapper cardMapper;
    @Autowired
    private CardService cardService;

    @GetMapping("/{id}")
    public UserDto get(@PathVariable("/{id}") Long id) {
        return userMapper.toDto(userService.get(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(UserDto request) {
        return userService.create(userMapper.toEntity(request));
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable("id") Long id, @RequestBody UserDto request) {
        request.setId(id);
        return userMapper.toDto(userService.update(userMapper.toEntity(request)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @PostMapping("/{id}/cards")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createUserCard(@PathVariable("id") Long userId, @RequestBody CardDto request) {
        request.setOwner(userId);
        return cardService.create(cardMapper.toEntity(request));
    }

    //TODO: Security filters validating the user's permissions over the cards may be interesting to fully take advantage of these restful paths.
    @PutMapping("/{userId}/cards/{cardId}")
    public CardDto updateUserCard(
        @PathVariable("userId") Long userId,
        @PathVariable("cardId") Long cardId,
        @RequestBody CardDto request
    ) {
        request.setOwner(userId);
        request.setId(cardId);
        return cardMapper.toDto(cardService.update(cardMapper.toEntity(request)));
    }

    @GetMapping("/{userId}/card/{cardId}")
    public CardDto getUserCard(@PathVariable("/{id}") Long id) {
        return cardMapper.toDto(cardService.get(id));
    }

    @DeleteMapping("/{userId}/card/{cardId}")
    public void deleteUserCard(@PathVariable("userId") Long userId, @PathVariable("cardId") Long cardId) {
        cardService.delete(cardId);
    }

    @GetMapping("/{id}/cards")
    public Page<CardDto> getUserCards(
        @PathVariable("id") Long owner,
        @RequestParam(value = "number", required = false) String number,
        @RequestParam(value = "flag", required = false) CardFlag flag,
        @PageableDefault Pageable pageable
    ) {
        return new PageImpl<>(
            cardService.getAll(flag, number, owner, pageable)
            .stream()
            .map(cardMapper::toDto)
            .collect(Collectors.toList())
        );
    }
}
