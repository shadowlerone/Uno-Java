package com.shadowlerone.uno.UNO_DECK;

import com.shadowlerone.uno.Card;
import com.shadowlerone.uno.Effect;

public class UnoCards {
	static public Card WILD_DRAW_FOUR(){
		return new Card("+4", "Wild", new UnoEffects.DrawFourWild(), true,true);
	}
	static public Card WILD() {
		return new Card("", "Wild", new UnoEffects.ChangeSuite(), false, true);
	}

	public static Card DRAW_TWO(String s) {
		return new Card("+2", s, new UnoEffects.DrawTwo(), false, false);
	}

	public static Card REVERSE(String s) {
		return new Card("Reverse", s, new UnoEffects.Reverse(), false, false);
	}

	public static Card SKIP(String s) {
		return new Card("Skip", s, new UnoEffects.Skip(), false, false);
	}
}
