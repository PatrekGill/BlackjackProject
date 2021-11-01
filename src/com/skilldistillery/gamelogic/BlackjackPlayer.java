package com.skilldistillery.gamelogic;

import com.skilldistillery.cards.Card;
import com.skilldistillery.players.Player;

public class BlackjackPlayer extends Player implements PersonWithBlackjackHand {
    private final BlackjackHand hand;

    public BlackjackPlayer(String name,int money) {
        super(name,money);
        hand = new BlackjackHand();
    }


    /* ------------------------------------------------
        addCardToHand
    ------------------------------------------------ */
    public void addCardToHand(Card card) {
        hand.addCard(card);
    }


    /* ------------------------------------------------
        get hand value
    ------------------------------------------------ */
    public int getHandValue() {
        return hand.getHandValue();
    }


    /* ------------------------------------------------
        isHandBust
    ------------------------------------------------ */
    public boolean isHandBust() {
        return hand.isBust();
    }


    /* ------------------------------------------------
        isHandNatural
    ------------------------------------------------ */
    public boolean isHandNatural() {
        return hand.isNatural();
    }


    /* ------------------------------------------------
        clearHand
    ------------------------------------------------ */
    public void clearHand() {
        hand.clear();
    }

    
    /* ------------------------------------------------
        showHand
    ------------------------------------------------ */
    @Override
    public void showHand(boolean showValue) {
        String handAsString = getName() + "'s " + hand.getCardsAsString();
        if (showValue) {
            handAsString = handAsString.replaceFirst(":"," (Value: " + getHandValue() + "):");
        }

        System.out.print(handAsString);

    }
}
