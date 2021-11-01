package com.skilldistillery.gamelogic;

import com.skilldistillery.cards.*;
import com.skilldistillery.players.*;

public class BlackjackDealer extends Dealer implements PersonWithBlackjackHand {
    private final BlackjackHand hand;
    private boolean hidingCard;

    public BlackjackDealer() {
        super();
        hidingCard = true;
        hand = new BlackjackHand();
    }


    /* ------------------------------------------------
        get/set hiding card
    ------------------------------------------------ */
    public void setHidingCard(boolean hidingCard) {
        this.hidingCard = hidingCard;
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
        String handAsString = hand.getCardsAsString();

        if (hidingCard) {
            handAsString = handAsString.replaceFirst("\\n(.+\\n)", "\n\t- Hidden Card\n");
        }

        if (showValue) {
            handAsString = handAsString.replaceFirst(":"," (Value: " + getHandValue() + "):");
        }
        System.out.print("Dealer's " + handAsString);
    }
}
