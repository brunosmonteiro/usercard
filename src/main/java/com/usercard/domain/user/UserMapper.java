package com.usercard.domain.user;

import org.mapstruct.Mapper;

@Mapper
interface UserMapper {
    UserEntity toUserEntity(UserDto dto);
}
