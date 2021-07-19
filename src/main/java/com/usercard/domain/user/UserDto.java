package com.usercard.domain.user;

import com.usercard.bases.BaseDto;
import com.usercard.domain.card.CardDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

import static com.usercard.error.MessageConstants.PHONE_NUMBER_INVALID;
import static com.usercard.error.MessageConstants.USER_NAME_BLANK;
import static com.usercard.utils.RegexUtils.VALID_PHONE_NUMBER_REGEX;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDto extends BaseDto {
    @NotEmpty(message = USER_NAME_BLANK)
    private String name;
    @Pattern(message = PHONE_NUMBER_INVALID, regexp = VALID_PHONE_NUMBER_REGEX)
    private String phoneNumber;
    private List<CardDto> cards;
}
