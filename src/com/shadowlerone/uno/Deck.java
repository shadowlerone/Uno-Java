package com.shadowlerone.uno;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	public ArrayList<Card> unplayed;
	public ArrayList<Card> discard;
	public ArrayList<String> suites;
	public Deck(){
		unplayed = new ArrayList<>();
		discard = new ArrayList<>();
	}
	void shuffle() {
		Collections.shuffle(unplayed);
	}
	public Card getTop(){
		return discard.get(discard.size() - 1);
	}

	public void reshuffle() {
		unplayed.addAll(discard);
		discard.clear();
		shuffle();
	}

	public void play_first() {
		discard.add(unplayed.remove(0));
	}
}
