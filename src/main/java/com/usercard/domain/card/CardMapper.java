package com.usercard.domain.card;

import com.usercard.bases.BaseMapper;
import com.usercard.domain.user.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(uses = {UserMapper.class}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class CardMapper extends BaseMapper<CardDto, Card> {
}
