package com.usercard.domain.user;

import com.usercard.bases.BaseEntity;
import com.usercard.domain.card.Card;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "tb_user")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    private String phoneNumber;
    private String name;
    @OneToMany(mappedBy = "owner", cascade = {CascadeType.ALL})
    private List<Card> cards;
}
