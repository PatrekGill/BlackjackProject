package com.skilldistillery.gamelogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.menus.Menu;
import com.skilldistillery.players.Player;

public class BlackjackMenu extends Menu {
    private final BlackjackDealer dealer;

    public BlackjackMenu(Scanner scanner, BlackjackDealer dealer) {
        super(scanner);
        this.dealer = dealer;
    }

    /* ------------------------------------------------
        getPlayerNamesMenu
    ------------------------------------------------ */
    public List<String> getPlayerNamesMenu() {
        int numberOfPlayers = 0;

        do {
            numberOfPlayers = getNextInt("Enter in the number of players between 1-6: ");
            if (numberOfPlayers < 1 || numberOfPlayers > 6) {
                System.out.println("Please enter a number between 1-6");
                numberOfPlayers = 0;
            }
        } while (numberOfPlayers == 0);

        List<String> playerNames = new ArrayList<>(numberOfPlayers);
        for (int i = 0; i < numberOfPlayers; i++) {
            playerNames.add(getNextLine("Enter in the name for Player " + (i + 1) + ": "));
        }

        return playerNames;
    }


    /* ------------------------------------------------
        hitOrStayMenu
    ------------------------------------------------ */
    public void hitOrStayMenu(BlackjackPlayer player) {
        boolean hitting = true;

        int choice;
        do {
            System.out.println("\n===========================");
            System.out.println(player.getName() + "'s turn:");
            player.showHand(true);
            System.out.println("1. Hit");
            System.out.println("2. Stay");
            System.out.println("===========================");

            choice = getNextInt("Your choice: ");
            switch (choice) {
                case 1: {
                    dealer.dealCard(player);
                    break;
                }
                case 2: {
                    hitting = false;
                    break;
                }
                default: {
                    printInvalidEntry();
                    break;
                }
            }

            System.out.println(); // gap in console

        } while (hitting && (!player.isHandBust()) && (!dealer.deckIsEmpty()));

        if (player.isHandBust()) {
            System.out.println(player.getName() + " busted");
            player.showHand(true);
            player.setPlaying(false);
        }
    }


    /* ------------------------------------------------
        placeBetMenu
    ------------------------------------------------ */
    public void placeBetMenu(Player player) {
        double betAmount = 0;
        double playerMoney = player.getTotalMoney();
        String playerName = player.getName();
        do {
            System.out.println("\n===========================");
            System.out.println(playerName + " please place a bet:");
            System.out.println("Your current balance is: " + playerMoney);
            System.out.println("===============================");

            betAmount = getNextDouble("Amount: ");

        } while ((betAmount <= 0) || (betAmount > playerMoney));

        System.out.println(playerName + " placed a bet of: " + betAmount);
        player.setCurrentBet(betAmount);
    }


    /* ------------------------------------------------
        playAgainMenu
    ------------------------------------------------ */
    public boolean playAgainMenu() {
        boolean playingAgain = false;

        int choice;
        do {
            System.out.println("\n===========================");
            System.out.println("1. Play another round (all players with money carryover)");
            System.out.println("2. Quit");
            System.out.println("===============================");

            choice = getNextInt("Your choice: ");
            switch (choice) {
                case 1: {
                    playingAgain = true;
                    System.out.println("Playing again...");
                    break;
                }
                case 2: {
                    System.out.println("Quitting...");
                    break;
                }
                default: {
                    printInvalidEntry();
                    choice = -1;
                    break;
                }
            }

            System.out.println(); // gap in console

        } while (choice == -1);

        return playingAgain;
    }


}

