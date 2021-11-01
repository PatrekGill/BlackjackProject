package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
    protected final List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }
    

    /* ------------------------------------------------
        addCard
    ------------------------------------------------ */
    public void addCard(Card card) {
        cards.add(card);
    }


    /* ------------------------------------------------
        clear
    ------------------------------------------------ */
    public void clear() {
        cards.clear();
    }


    /* ------------------------------------------------
        getCardsAsString
    ------------------------------------------------ */
    public String getCardsAsString() {
        StringBuilder sb = new StringBuilder("Cards:\n");

        for (Card card : cards) {
            sb.append("\t- ");
            sb.append(card);
            sb.append("\n");
        }

        return sb.toString();
    }
}