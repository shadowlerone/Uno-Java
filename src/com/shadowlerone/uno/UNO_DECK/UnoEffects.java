package com.shadowlerone.uno.UNO_DECK;

import com.shadowlerone.uno.Effect;
import com.shadowlerone.uno.Game;

import java.util.ArrayList;
import java.util.List;

public class UnoEffects {
	static class DrawTwo extends Effect {
//		public List<String> this.tags;
		public void call(Game g){
			g.draw_count += 2;
		}
		public DrawTwo(){
			tags = new ArrayList<>();
			String name = "Draw 2";
			String desc = "Next player draws 2 cards";
			this.tags.add(CONSTANTS.DRAW);
		}
	}
	static class DrawFourWild extends Effect {
//		public List<String> tags;
		public DrawFourWild(){
			tags = new ArrayList<>();
			name = "Draw 4 Wild";
			desc = "Draw 4 Cards and change playable color";
			tags.add(CONSTANTS.DRAW);
			tags.add(CONSTANTS.COLOR_CHANGE);
		}
		public void call(Game g){
			g.draw_count += 4;
			g.changeSuite();
		}
	}
	static class ChangeSuite extends Effect {
//		public List<String> tags;
		public ChangeSuite(){
			tags = new ArrayList<>();
			String name = "Change Suite";
			String desc = "Changes color in play";
			tags.add(CONSTANTS.COLOR_CHANGE);
		}
		public void call(Game g) {
			g.changeSuite();
		}
	}
	static class Reverse extends Effect {
//		public List<String> tags;
		public Reverse(){
			tags = new ArrayList<>();
			name = "Reverse";
			desc = "Reverse player order";
			tags.add(CONSTANTS.REVERSE);
		}
		public void call(Game g){
			g.reverse();
		}
	}

	static public class Skip extends Effect {
//		public List<String> tags;
		String name = "Skip";
		String desc = "Skip next player";
		public void call (Game g){
			g.skips += 1;
		}
	}
}
