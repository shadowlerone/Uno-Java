package com.shadowlerone.uno.UNO_DECK;

import com.shadowlerone.uno.Card;
import com.shadowlerone.uno.Deck;
import com.shadowlerone.uno.Effect;

import java.util.ArrayList;
import java.util.List;

//import static com.shadowlerone.uno.UNO_DECK.UnoCards;

public class UnoDeck extends Deck {
	public UnoDeck(){
		unplayed = new ArrayList<>();
		discard = new ArrayList<>();
		suites = new ArrayList<String>();
		suites.add("Red");
		suites.add("Orange");
		suites.add("Green");
		suites.add("Blue");
		// 4 Wild Draw 4
		unplayed.add(UnoCards.WILD_DRAW_FOUR());
		unplayed.add(UnoCards.WILD_DRAW_FOUR());
		unplayed.add(UnoCards.WILD_DRAW_FOUR());
		unplayed.add(UnoCards.WILD_DRAW_FOUR());

		// 4 Wilds
		unplayed.add(UnoCards.WILD());
		unplayed.add(UnoCards.WILD());
		unplayed.add(UnoCards.WILD());
		unplayed.add(UnoCards.WILD());

		// Nested loops, yay!

		// Draw 2
		suites.forEach(s -> {
			unplayed.add(UnoCards.DRAW_TWO(s));
			unplayed.add(UnoCards.DRAW_TWO(s));
		});
		// Reverse
		suites.forEach(s -> {
			unplayed.add(UnoCards.REVERSE(s));
			unplayed.add(UnoCards.REVERSE(s));
		});
		// Skip
		suites.forEach(s -> {
			unplayed.add(UnoCards.SKIP(s));
			unplayed.add(UnoCards.SKIP(s));
		});
		for (String s: suites){
			unplayed.add(new Card("0", s, new Effect(), false, false));
			unplayed.add(new Card("1", s, new Effect(), false, false));
			unplayed.add(new Card("1", s, new Effect(), false, false));
			unplayed.add(new Card("2", s, new Effect(), false, false));
			unplayed.add(new Card("2", s, new Effect(), false, false));
			unplayed.add(new Card("3", s, new Effect(), false, false));
			unplayed.add(new Card("3", s, new Effect(), false, false));
			unplayed.add(new Card("4", s, new Effect(), false, false));
			unplayed.add(new Card("4", s, new Effect(), false, false));
			unplayed.add(new Card("5", s, new Effect(), false, false));
			unplayed.add(new Card("5", s, new Effect(), false, false));
			unplayed.add(new Card("6", s, new Effect(), false, false));
			unplayed.add(new Card("6", s, new Effect(), false, false));
			unplayed.add(new Card("7", s, new Effect(), false, false));
			unplayed.add(new Card("7", s, new Effect(), false, false));
			unplayed.add(new Card("8", s, new Effect(), false, false));
			unplayed.add(new Card("8", s, new Effect(), false, false));
			unplayed.add(new Card("9", s, new Effect(), false, false));
			unplayed.add(new Card("9", s, new Effect(), false, false));
		}
	}
}
