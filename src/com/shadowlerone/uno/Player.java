package com.shadowlerone.uno;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import static com.shadowlerone.uno.text.SHOW_OPTIONS;

public class Player {

	public List<Card> hand;
	public Player(){
		hand = new ArrayList<>();
	}
	public void displayHand() {
		List<String> o = hand.stream()
								 .map(card -> card.getName())
								 .collect(Collectors.toList());
		System.out.println(SHOW_OPTIONS(o));
	}

	public void draw(Deck deck, int draw_count) {
		for (int i = 0; i < draw_count; i++) {
			if (deck.unplayed.isEmpty()) {
				deck.reshuffle();
			}
			hand.add(deck.unplayed.remove(0));
		}

	}

	public List<Card> getPlayable(Card.PlayCondition pc) {
		return this.hand.stream()
					   .filter(pc::checkCondition)
					   .collect(Collectors.toList());
	}
}
