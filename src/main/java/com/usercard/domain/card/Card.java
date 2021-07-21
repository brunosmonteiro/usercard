package com.usercard.domain.card;

import com.usercard.bases.BaseEntity;
import com.usercard.domain.user.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Card extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private CardFlag flag;
    private String number;
    @ManyToOne
    private User owner;
}
