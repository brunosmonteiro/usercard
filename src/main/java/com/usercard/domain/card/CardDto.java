package com.usercard.domain.card;

import com.usercard.bases.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CardDto extends BaseDto {
    private CardFlag flag;
    private String number;
    private Long owner;
}
