package com.usercard.domain.user;

import com.usercard.bases.BaseEntity;
import com.usercard.domain.card.Card;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
public class User extends BaseEntity {
    private String phoneNumber;
    private String name;
    @OneToMany(mappedBy = "owner")
    private List<Card> cards;
}