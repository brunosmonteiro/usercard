package com.usercard.domain.user;

import com.usercard.bases.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class UserMapper extends BaseMapper<UserDto, User> {
}
