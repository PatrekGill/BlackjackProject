package com.skilldistillery.main;

import java.util.Scanner;

import com.skilldistillery.gamelogic.BlackjackTable;

public class BlackjackApp {
    private final Scanner scanner;
    public BlackjackApp() {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        BlackjackApp app = new BlackjackApp();
        app.launch();
        app.close();
    }

    private void launch() {
        BlackjackTable table = new BlackjackTable(scanner);
        table.startGame();
    }

    private void close() {
        scanner.close();
    }
}
