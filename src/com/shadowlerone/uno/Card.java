package com.shadowlerone.uno;

import jdk.jfr.ContentType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Card {
	String number;
	String suite;
	public Effect effect;
	private boolean override_suite;
	private boolean override_number;
	public Card(String number,String suite, Effect effect, boolean override_number, boolean override_suite){
		this.number = number;
		this.suite = suite;
		this.effect = effect;
		this.override_number = override_number;
		this.override_suite = override_suite;
	}
	public String getNumber(){
		return number;
	}
	public String getSuite(){
		return suite;
	}

	public boolean isOverride_number() {
		return override_number;
	}

	public boolean isOverride_suite() {
		return override_suite;
	}

	public String details() {
		return String.format("Suite: %s; Number: %s; Effect: %s", suite, number, effect.desc);
	}

	public String getName() {
		return suite + " " + number;
	}

	public static class PlayCondition{
		String suite;
		String number;
		public List<String> tags;
		public PlayCondition(@NotNull Card top_card){
			suite = top_card.getSuite();
			number = top_card.getNumber();
			tags = new ArrayList<>();
			if (top_card.effect.tags.contains(Effect.CONSTANTS.DRAW))
				tags.add(Effect.CONSTANTS.DRAW);
//			tags.addAll(top_card.effect.tags);
//			tags.forEach(t -> System.out.println(t));
		}

		public String getSuite() {
			return suite;
		}

		public void setSuite(String suite) {
			this.suite = suite;
		}

		public boolean checkCondition(Card c){
			/*
				1. Check draw tags
				2. check suite and number overrides
				3. check color and number
			 */
			// DRAW
			if (tags.contains(Effect.CONSTANTS.DRAW)){
				return c.effect.tags.contains(Effect.CONSTANTS.DRAW) && checkSuite(c);
			}
			// Suite and Number Override
			if (c.override_suite){
				return true;
			}
			if (c.override_number && (checkSuite(c))){
				return true;
			}
			// Color and suite
			return (checkSuite(c) || checkNumber(c));
		}

		private boolean checkSuite (Card c){
			return (c.override_suite || (c.suite == this.suite));
		}
		private boolean checkNumber (Card c){
			return (c.override_number || c.number == this.number);
		}
	}
}
