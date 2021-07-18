package com.usercard.domain.card;

import com.usercard.bases.BaseMapper;
import com.usercard.domain.user.UserMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {UserMapper.class})
public abstract class CardMapper extends BaseMapper<CardDto, Card> {
}
