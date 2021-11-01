package com.skilldistillery.gamelogic;

import com.skilldistillery.cards.Card;

public interface PersonWithBlackjackHand {
    void addCardToHand(Card card);
    int getHandValue();
    boolean isHandBust();
    boolean isHandNatural();
    void showHand(boolean showValue);
    void clearHand();
}
