package com.usercard.domain.card;

import com.usercard.bases.BaseEntity;
import com.usercard.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table
@Getter
@Setter
public class Card extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private CardFlag flag;
    private String number;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}
