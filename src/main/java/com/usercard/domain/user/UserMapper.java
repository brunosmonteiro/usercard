package com.usercard.domain.user;

import com.usercard.bases.BaseMapper;
import com.usercard.domain.card.CardMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(uses = CardMapper.class, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class UserMapper extends BaseMapper<UserDto, User> {
}
