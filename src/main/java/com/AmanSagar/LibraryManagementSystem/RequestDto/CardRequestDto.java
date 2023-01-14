package com.AmanSagar.LibraryManagementSystem.RequestDto;

import com.AmanSagar.LibraryManagementSystem.enums.CardStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CardRequestDto {

    private CardStatus cardstatus;

    private int studentid;
}
