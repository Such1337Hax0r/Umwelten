package server;

import java.util.ArrayList;

public class Player extends Thing {
	String Uname;
	int Pain;
	int Hunger;
	ArrayList<Object> Inventory;

	public Player(String U, int X, int Y) {
		super(209, false, false, true, false, 10, true, false, false, false, false, true, X, Y);
		this.Uname = U;
		this.Pain = 0;
		this.Hunger = 1;
		this.Inventory = new ArrayList<Object>();
	}

}
