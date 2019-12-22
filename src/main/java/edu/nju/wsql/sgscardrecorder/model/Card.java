package edu.nju.wsql.sgscardrecorder.model;

import edu.nju.wsql.sgscardrecorder.model.enums.Suit;
import lombok.Data;
import lombok.NonNull;

@Data
public class Card {
    @NonNull
    private Suit suit;
    @NonNull
    private String point;

    private String name;
}
