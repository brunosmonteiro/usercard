package com.usercard.domain.card;

import com.usercard.bases.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CardService extends BaseService<Card> {
    public Page<Card> getAll(CardFlag flag, String number, Long owner, Pageable pageable) {
        return repository.findAll(CardSpecification.get(flag, number, owner), pageable);
    }
}
