package com.shadowlerone.uno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

...
Queue<Card> deck = Collections.asLifoQueue(new LinkedList<>());

 */
public class Stack {
	public Queue<Effect> stack_attack;
	void run(Game g){
		while (!stack_attack.isEmpty()) {
			stack_attack.remove().call(g);
		}
	}
	public Stack(){
		stack_attack = Collections.asLifoQueue(new LinkedList<>());
	}
	void reset() {
		stack_attack.clear();
	}
}