package server;

public class Player extends Thing{
	String Uname;
	public Player(String U, int X, int Y) {
		super(209, false, false, true, false, 10, true, false, false, false, false, X, Y);
		this.Uname = U;
	}

}
