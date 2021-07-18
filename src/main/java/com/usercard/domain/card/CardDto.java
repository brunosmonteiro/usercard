package com.usercard.domain.card;

import com.usercard.bases.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDto extends BaseDto {
    private CardFlag flag;
    private String number;
    private Long owner;
}
