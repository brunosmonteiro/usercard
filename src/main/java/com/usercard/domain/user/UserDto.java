package com.usercard.domain.user;

import lombok.Data;

import javax.validation.constraints.Pattern;

import static com.usercard.error.MessageConstants.PHONE_NUMBER_INVALID;
import static com.usercard.error.MessageConstants.USER_NAME_INVALID;
import static com.usercard.utils.RegexUtils.VALID_PHONE_NUMBER_REGEX;
import static com.usercard.utils.RegexUtils.VALID_USER_NAME_REGEX;

@Data
public class UserDto {
    private Long id;
    @Pattern(message = USER_NAME_INVALID, regexp = VALID_USER_NAME_REGEX)
    private String name;
    @Pattern(message = PHONE_NUMBER_INVALID, regexp = VALID_PHONE_NUMBER_REGEX)
    private String phoneNumber;
}
