package server;

import java.io.*;
import java.net.*;

public class ClientHandler extends Thread {
	Socket CurrentlyHandling;
	private int[] In = new int[10000];
	private int[] Out;
	Player T;

	public ClientHandler(Socket a) {
		this.CurrentlyHandling = a;
		
	}
	public void setPlayer(Thing[][][] map, String User) {
		for(int x = 0; x < map.length; x ++) {
			for(int z = 0; z < map.length; z ++) {
				if(map[z][x][y].identifier == 205) T = new Player(User, x, 50, z);
			}
		}
		
	}
	public void run() {
		// If handler exists add it to the list
		if (CurrentlyHandling != null)
			Main.AL.add(this);
		BufferedInputStream R = null;
		BufferedOutputStream W = null;
		// Declare the input and output. Input is R, Output is W
		try {
			R = new BufferedInputStream(CurrentlyHandling.getInputStream());
			W = new BufferedOutputStream(CurrentlyHandling.getOutputStream());
		} catch (IOException e) {
			// If there is an error, print funny error message, along with print
			// the stack trace
			System.out.println("You had one job!");
			System.out.println("And you couldn't even do it!");
			System.out.println("(IOException)");
			e.printStackTrace();
		}
		int[] oldData = null;
		while (!CurrentlyHandling.isClosed()) {
			In = readData(R);
			oldData = sendData(Out, oldData, W);
			try {
				if (T.Pain >= 100) {
					T.x = 51;
					T.y = 125;
				}
			} catch (NullPointerException e) {
				System.out.println("Nonexistant client");
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.err.println("InterruptedException");
				e.printStackTrace();
			}
		}
		// Remove the current handler from the list
		Main.AL.remove(this);
	}

	// Get in function, returns a byte array
	public int[] getIn() {
		return In;
	}

	// Set out function
	public void setOut(int[] toSend) {
		Out = toSend;
	}

	// Returns currently sent, only sends if there is a difference between the
	// two
	private int[] sendData(int[] toSend, int[] previouslySent, BufferedOutputStream O) {
		if (toSend != previouslySent) {
			for (int jk : toSend) {
				try {
					O.write(jk);
					O.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return toSend;
	}

	// For reading data, returns the data as a Byte array
	private int[] readData(BufferedInputStream I) {
		int Available = 0;
		try {
			Available = I.available();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int[] returning = new int[Available];
		try {
			Available = I.available();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < Available; i++) {
			try {
				returning[i] = I.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return returning;
	}
}
