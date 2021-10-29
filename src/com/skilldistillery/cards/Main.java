package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Card> cards = new ArrayList<>();
		Deck deck = new Deck();
		deck.shuffleDeck();
		cards.add(deck.drawCard());
		cards.add(deck.drawCard());
		cards.add(deck.drawCard());
		
		System.out.println(cards);
	}
}
