package com.skilldistillery.players;

import com.skilldistillery.cards.*;
import com.skilldistillery.gamelogic.*;

public abstract class Dealer {
    private final Deck deck;

    public Dealer() {
        this.deck = new Deck();
        deck.shuffleDeck();
    }

    /* ------------------------------------------------
        shuffleCards
    ------------------------------------------------ */
    public void shuffleCards() {
        deck.shuffleDeck();
    }


    /* ------------------------------------------------
        dealCard
    ------------------------------------------------ */
    public void dealCard(PersonWithBlackjackHand personWithHand) {
        Card card = deck.drawCard();
        personWithHand.addCardToHand(card);
    }


    /* ------------------------------------------------
        resetDeck
    ------------------------------------------------ */
    public void resetDeck() {
        deck.resetDeck();
    }


    /* ------------------------------------------------
        deckIsEmpty
    ------------------------------------------------ */
    public boolean deckIsEmpty() {
        return deck.isEmpty();
    }
}
