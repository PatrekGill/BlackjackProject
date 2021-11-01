package com.skilldistillery.gamelogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.Table;

public class BlackjackTable extends Table<BlackjackPlayer> {
    private final BlackjackDealer dealer;
    private final BlackjackMenu menu;
    private final List<PersonWithBlackjackHand> playersAndDealer;

    public BlackjackTable(Scanner scanner) {
        super();

        dealer = new BlackjackDealer();
        playersAndDealer = new ArrayList<>(players);
        playersAndDealer.add(dealer);

        menu = new BlackjackMenu(scanner,dealer);
    }

    @Override
    public void startGame() {

        createPlayers();

        do {
            askPlayersForBets();
            dealCardsAtStart();
            checkForNaturals();
            showTable(false);

            askPlayersToHitOrStay();

            dealer.setHidingCard(false);
            while (dealer.getHandValue() < 17) {
                dealer.dealCard(dealer);
            }

            showTable(true);

            decidePayouts();
        } while (askToPlayAgain() && resetGameState());

        System.out.println("Blackjack game has ended");

    }


    /* ------------------------------------------------
        askPlayersForBets
    ------------------------------------------------ */
    private void askPlayersForBets() {
        for (BlackjackPlayer player : players) {
            if (player.isPlaying()) {
                menu.placeBetMenu(player);
            }
        }
    }


    /* ------------------------------------------------
        askPlayersToHitOrStay
    ------------------------------------------------ */
    private void askPlayersToHitOrStay() {
        for (BlackjackPlayer player : players) {
            if (player.isPlaying()) {
                menu.hitOrStayMenu(player);
            }
        }
    }


    /* ------------------------------------------------
        askToPlayAgain
    ------------------------------------------------ */
    private boolean askToPlayAgain() {
        return menu.playAgainMenu();
    }


    /* ------------------------------------------------
        createPlayers
    ------------------------------------------------ */
    private void createPlayers() {
        List<String> playerNames = menu.getPlayerNamesMenu();

        for (String name : playerNames) {
            BlackjackPlayer player = new BlackjackPlayer(name,1000);
            playersAndDealer.add(player);
            players.add(player);
        }
    }


    /* ------------------------------------------------
        checkForNaturals
    ------------------------------------------------ */
    private void checkForNaturals() {
        for (BlackjackPlayer player : players) {
            if (player.isHandNatural()) {
                player.setPlaying(false);
            }
        }
    }


    /* ------------------------------------------------
        dealCardsAtStart
    ------------------------------------------------ */
    private void dealCardsAtStart() {
        // deal two cards to everybody
        for (int i = 0; i < 2; i++) {
            for (PersonWithBlackjackHand player : playersAndDealer) {
                dealer.dealCard(player);
            }
        }
    }


    /* ------------------------------------------------
        decidePayouts
    ------------------------------------------------ */
    private void decidePayouts() {
        int dealersHandValue = dealer.getHandValue();
        boolean dealerBusted = dealer.isHandBust();

        double playersBet;
        double playersCurrentMoney;
        int playersHandValue;
        String playersName;

        for (BlackjackPlayer player : players) {
            playersBet = player.getCurrentBet();
            playersCurrentMoney = player.getTotalMoney();
            playersHandValue = player.getHandValue();
            playersName = player.getName();

            // players pay when:
            // they bust or
            // when the dealer did not bust and the player did not bust but has a lesser valued hand
            if (player.isHandBust() || (playersHandValue < dealersHandValue && !dealerBusted)) {
                System.out.println(playersName + " lost to the dealer");
                player.setTotalMoney(playersCurrentMoney - playersBet);

            } else if ((playersHandValue == 21) && (dealersHandValue != 21)) {

                if (player.isHandNatural()) {
                    System.out.println(playersName + " got a Blackjack!");
                    player.setTotalMoney(playersCurrentMoney + (playersBet + (playersBet * 1.5)));

                } else {
                    System.out.println(playersName + " got 21!");
                    player.setTotalMoney(playersCurrentMoney + playersBet);

                }

            } else if (playersHandValue > dealersHandValue) {
                System.out.println(playersName + " beat the dealer!");
                player.setTotalMoney(playersCurrentMoney + playersBet);

            } else {
                System.out.println(playersName + " tied with the dealer.");
            }

            System.out.println(player.getName() + "'s current money: " + player.getTotalMoney());
            player.setCurrentBet(0);
        }
    }


    /* ------------------------------------------------
        resetGameState
    ------------------------------------------------ */
    private boolean resetGameState() {
        // remove players with no money
        boolean thereArePlayersWithMoney;
        for (BlackjackPlayer player : players) {
            if (player.getTotalMoney() <= 0) {
                System.out.println(player.getName() + " has no money left and is out of the game...");
                players.remove(player);
                playersAndDealer.remove(player);

            } else {
                player.setPlaying(true);

            }
        }

        thereArePlayersWithMoney = !players.isEmpty();
        if (thereArePlayersWithMoney) {
            // repopulate the deck
            dealer.resetDeck();
            dealer.shuffleCards();
            dealer.setHidingCard(true);
            System.out.println("Deck was reshuffled...");

            for (PersonWithBlackjackHand player : playersAndDealer) {
                player.clearHand();
            }

        } else {
            System.out.println("All players are out of money, the game will not continue...");

        }

        return thereArePlayersWithMoney;
    }


    /* ------------------------------------------------
        showTable
    ------------------------------------------------ */
    private void showTable(boolean showHandValues) {
        System.out.println("\n===============================");
        for (PersonWithBlackjackHand player : playersAndDealer) {
            player.showHand(showHandValues);
        }
        System.out.println("===============================\n");
    }
}
