package com.shadowlerone.uno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {
	// Init
	public Card top_card;
	public Deck deck;
	public List<Player> players;
	public Player turn_player;
	public int current_player_index, draw_count, skips, player_count;
	public Stack stack;
	public boolean done;
	private int[] player_order;
	private byte direction;
	public Card.PlayCondition playcondition;
	List<Card> options;
	//End Init


	public Game(Deck d, int player_count){
		this.player_count = player_count;
		deck = d;
		current_player_index = 0;
		done = false;
		skips = 0;
		direction = 1;
		draw_count = 0;
		stack = new Stack();
	}


	public void start(){
		System.out.println(text.GAME_START);
		players = new ArrayList<>();
		deck.shuffle();
		for (int p = 0; p < player_count; p++) players.add(new Player());
		for (Player p : players) p.draw(deck, 7);
		deck.play_first();

	}


	public void turn(){
		// Turn Setup
		// Get Top Card

		top_card = deck.getTop();

		// Initialize Play Condition for this turn
		playcondition = new Card.PlayCondition(top_card);

		skips = 0;

		// Collapse the stack.
		stack.run(this);

		// Selects current player.
		current_player_index = Math.floorMod((current_player_index + (1+skips)*direction), (players.size()));
		turn_player = players.get(current_player_index);
		System.out.println("====================");
		System.out.println("Player " + current_player_index + "'s turn.");
		// Display top card

		System.out.println(text.TOP_CARD + top_card.getName());

		// Show player hand.
		turn_player.displayHand();
		options = turn_player.getPlayable(playcondition);

		// if no options
		if (options.size() < 1) {
			turn_player.draw(deck, Math.max(draw_count, 1));
			stack.reset();
			System.out.println(text.NO_OPTION);
			System.out.println(text.DRAW(Math.max(draw_count, 1)));
			draw_count = 0;
			return;
		}
		play();
		if (turn_player.hand.isEmpty())
			over(turn_player);
	}

	private void over(Player p) {
		System.out.println(text.GAME_OVER(p));
		done = true;
	}

	private void play() {

		Card c = interaction.SELECT_OPTION(options);

		int played = turn_player.hand.indexOf(c);

		stack.stack_attack.add(c.effect);

		deck.discard.add(turn_player.hand.remove(played));

	}

	public void changeSuite(){
		playcondition.setSuite(deck.suites.get(interaction.SELECT_SUITE(this.deck)));
	}

	public void reverse(){
		direction *= -1;
	}

	public static void main(String[] args) {
	}


	public static class interaction {
		static Scanner scanner = new Scanner(System.in);
		public static int SELECT_SUITE(Deck d) {
			System.out.println(text.SELECT_SUITE);
			return getInput(
					text.SHOW_OPTIONS(d.suites), 0, d.suites.size() -1 );
		}
//		public static ;
		public static int getInput(String question, int min, int max){
			boolean valid = false;
			int out = 0;
			while (!valid){
				System.out.println(question);
				if (scanner.hasNextInt()){
					out = scanner.nextInt();
					valid = (min <= out && out <= max);
				} else {
					System.out.println(text.INVALID_INPUT);
				}
			}
			return out;
		}

		public static Card SELECT_OPTION(List<Card> options) {
			List<String> o = options.stream()
									 .map(c -> c.getName())
									 .collect(Collectors.toList());
			return options.get(
					getInput(text.SHOW_OPTIONS(o), 0, options.size() -1 ));
		}
	}
}
class text {
	public static final String GAME_START = ">Game Starting";

	public static final String SELECT_SUITE = "Select a suite: ";

	public static final String INVALID_INPUT = "Invalid input, please select again: ";
	public static final String NO_OPTION = "You can't play anything";
	public static final String TOP_CARD = "Top Card is: ";

	public static String GAME_OVER(Player p){
		return "";
	}

	public static String DRAW(int dc){
		return "Drew " + dc + " cards";
	}

	public static String TURN(Player p){
		return "";
	}

	public static String SHOW_OPTIONS(List<String> options){
		StringBuilder q = new StringBuilder();
		for (int i = 0; i < options.size(); i++)
			q.append("[").append(i).append(": ").append(options.get(i)).append("]");
		return q.toString();
	}
}

