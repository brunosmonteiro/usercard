package com.usercard.domain.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class UserDto {
    @NotEmpty
    private String name;
    @Pattern(regexp = "")
    private String phoneNumber;
}
