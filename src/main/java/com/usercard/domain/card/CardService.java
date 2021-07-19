package com.usercard.domain.card;

import com.usercard.bases.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CardService extends BaseService<Card> {
    @Autowired
    private CardRepository cardRepository;

    public Page<Card> getAll(CardFlag flag, String number, Long owner, Pageable pageable) {
        return repository.findAll(CardSpecification.get(flag, number, owner), pageable);
    }
}
