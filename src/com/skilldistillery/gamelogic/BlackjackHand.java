package com.skilldistillery.gamelogic;

import com.skilldistillery.cards.*;

public class BlackjackHand extends Hand {

    /* ------------------------------------------------
        getHandValue
    ------------------------------------------------ */
    public int getHandValue() {
        int handValue = 0;

        boolean hasAce = false;
        for (Card card : cards) {

            if ((!hasAce) && card.getRank().equals(Rank.ACE)) {
                hasAce = true;
            }

            handValue += card.getValue();
        }

        if (hasAce && handValue <= 11) {
            handValue += 10;
        }

        return handValue;
    }

    /* ------------------------------------------------
        isBust
    ------------------------------------------------ */
    public boolean isBust() {
        return getHandValue() > 21;
    }


    /* ------------------------------------------------
        isNatural
    ------------------------------------------------ */
    public boolean isNatural() {
        return (getHandValue() == 21) && (cards.size() == 2);
    }

}
