package com.shadowlerone.uno;

import com.shadowlerone.uno.UNO_DECK.UnoDeck;

public class Main {

    public static void main(String[] args) {
		// write your code here
		Deck deck = new UnoDeck();
		Game g = new Game(deck, 4);
		g.start();
		while (!g.done) g.turn();
	}

}
