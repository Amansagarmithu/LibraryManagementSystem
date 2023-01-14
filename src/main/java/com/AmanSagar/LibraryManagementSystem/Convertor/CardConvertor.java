package com.AmanSagar.LibraryManagementSystem.Convertor;

import com.AmanSagar.LibraryManagementSystem.Module.Card;
import com.AmanSagar.LibraryManagementSystem.RequestDto.CardRequestDto;

public class CardConvertor {

    public static Card convertcard(CardRequestDto cardrequestdto){
        Card card = Card.builder().cardstatus(cardrequestdto.getCardstatus()).build();
        return card;
    }
}
