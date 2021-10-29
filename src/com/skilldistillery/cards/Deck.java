package com.skilldistillery.cards;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private final Stack<Card> cards;

    public Deck() {
        cards = new Stack<>();
        // populate deck
        populateDeck();
    }

    /* ------------------------------------------------
        shuffleDeck
    ------------------------------------------------ */
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }


    /* ------------------------------------------------
        drawCard
    ------------------------------------------------ */
    public Card drawCard() {
        if (!cards.isEmpty()) {
            return cards.pop();
        }

        return null;
    }


    /* ------------------------------------------------
        resetDeck
    ------------------------------------------------ */
    public void resetDeck() {
        cards.clear();
        populateDeck();
    }


    /* ------------------------------------------------
        populateDeck
    ------------------------------------------------ */
    private void populateDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.push(new Card(suit,rank));
            }
        }
    }


    /* ------------------------------------------------
        checkSize
    ------------------------------------------------ */
    public int checkSize() {
        return cards.size();
    }


    /* ------------------------------------------------
        isEmpty
    ------------------------------------------------ */
    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
