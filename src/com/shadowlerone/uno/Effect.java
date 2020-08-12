package com.shadowlerone.uno;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Effect {
	public void call(Game g){};
	public String name;
	public String desc;
	public List<String> tags;
	public Effect (){
		tags = new ArrayList<>();
		name = "";
		desc = "";
	}
	public static class CONSTANTS {
		public static final String DRAW = "D";
		public static final String COLOR_CHANGE = "CS";
		public static final String REVERSE = "R";
	}
}
