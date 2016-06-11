package server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Main {
	public static ArrayList<ClientHandler> AL = new ArrayList<ClientHandler>();
	static Thing[][] T = new Thing[500][500];
	static ArrayList<String> Str = new ArrayList<String>();
	public static void main(String Args[]) throws IOException {
		if (!(Args.length < 1 || Args.length > 1)) {
			System.out.println("Welcome to Umwelten sever, Enter quit to quit");
			int port = Integer.parseInt(Args[0]);
			ServerSocket s = new ServerSocket(port);
			Scanner S = new Scanner(System.in);
			int x = 0;
			for (Thing[] thi : T) {
				x++;
				for (int i = 0; i < thi.length; i++) {
					thi[i] = new Air(x, i);
				}
				if (x < 50) {
					for (int i = 0; i < thi.length; i++) {
						thi[i] = new Stone(x, i);
					}
					
				}
				T[x] = thi;
			}
			while (true) {
				Socket Client = s.accept();
				ClientHandler c = new ClientHandler(Client);
				c.run();
				char c1 = (char) c.getIn()[0];
				char c2 = (char) c.getIn()[1];
				char c3 = (char) c.getIn()[2];
				char c4 = (char) c.getIn()[3];
				String J = new String("" + c1 + c2 + c3 + c4);
				
				c.T = new Player(J, 51, 125);
				if (S.next().equals("quit")) {
					s.close();
					break;
				}
				int currentCode = 0;
				int It = 0;
				ArrayList<Integer> I = new ArrayList<Integer>();
				for (ClientHandler j : AL) {
					int Oldy = AL.get(It).T.y;
					int Oldx = AL.get(It).T.x;
					(T[Oldx][Oldy]) = new Air(Oldx, Oldy);
					(T[j.T.x][j.T.y]) = j.T;
					int[] b = j.getIn();
					for (int i = 0; i < b.length; i++) {
						currentCode = b[0];
						switch (currentCode) {
						case (101):
							I.add((T[j.T.x + 1][j.T.y]).identifier);
							I.add((T[j.T.x - 1][j.T.y]).identifier);
							I.add((T[j.T.x][j.T.y - 250]).identifier);
							I.add((T[j.T.x][j.T.y + 250]).identifier);
							I.add((T[j.T.x][j.T.y - 1]).identifier);
							I.add((T[j.T.x][j.T.y + 1]).identifier);
							break;
						case (102):
							int heatArea = 0;
							if((T[j.T.x + 1][j.T.y]).emitsHeat){
								heatArea++;
							}
							if((T[j.T.x - 1][j.T.y]).emitsHeat) {
								heatArea++;
							}
							if((T[j.T.x][j.T.y - 250]).emitsHeat) {
								heatArea++;
							}
							if((T[j.T.x][j.T.y + 250]).emitsHeat) {
								heatArea++;
							}
							if((T[j.T.x][j.T.y - 1]).emitsHeat) {
								heatArea++;
							}
							if((T[j.T.x][j.T.y + 1]).emitsHeat) {
								heatArea++;
							}
							I.add(heatArea);
							break;
						case (103):
							int pressArea = 0;
							if((T[j.T.x + 1][j.T.y]).emitsHeat){
								pressArea++;
							}
							if((T[j.T.x - 1][j.T.y]).emitsHeat) {
								pressArea++;
							}
							if((T[j.T.x][j.T.y - 250]).emitsHeat) {
								pressArea++;
							}
							if((T[j.T.x][j.T.y + 250]).emitsHeat) {
								pressArea++;
							}
							if((T[j.T.x][j.T.y - 1]).emitsHeat) {
								pressArea++;
							}
							if((T[j.T.x][j.T.y + 1]).emitsHeat) {
								pressArea++;
							}
							I.add(pressArea);
							break;
						case (104):
							//Hearing
							break;
						case (105):
							//Chat
							break;
						case (106):
							int purpArea = 0;
							if((T[j.T.x + 1][j.T.y]).emitsHeat){
								purpArea++;
							}
							if((T[j.T.x - 1][j.T.y]).emitsHeat) {
								purpArea++;
							}
							if((T[j.T.x][j.T.y - 250]).emitsHeat) {
								purpArea++;
							}
							if((T[j.T.x][j.T.y + 250]).emitsHeat) {
								purpArea++;
							}
							if((T[j.T.x][j.T.y - 1]).emitsHeat) {
								purpArea++;
							}
							if((T[j.T.x][j.T.y + 1]).emitsHeat) {
								purpArea++;
							}
							I.add(purpArea);
							break;
						case (107):
							I.add(j.T.Pain);
							break;
						case (108):
							I.add(j.T.Hunger);
							break;
//						case (109):
//							break;
						case (401):
							if (b[1] == 1 && !(T[j.T.x + 1][j.T.y].blocksPath)) {
								(T[j.T.x + 1][j.T.y]) = (T[j.T.x][j.T.y]);
								(T[j.T.x][j.T.y]) = new Air(j.T.x, j.T.y);
								j.T.x++;
							}
							else if (b[2] == 1 && !(T[j.T.x - 1][j.T.y]).blocksPath) {
								(T[j.T.x - 1][j.T.y]) = (T[j.T.x][j.T.y]);
								(T[j.T.x][j.T.y]) = new Air(j.T.x, j.T.y);
								j.T.x--;
							}
							else if (b[3] == 1 && !(T[j.T.x][j.T.y - 250]).blocksPath) {
								(T[j.T.x][j.T.y - 250]) = (T[j.T.x][j.T.y]);
								(T[j.T.x][j.T.y]) = new Air(j.T.x, j.T.y);
								j.T.y = j.T.y - 250;
							}
							else if (b[4] == 1 && !(T[j.T.x][j.T.y + 250]).blocksPath) {
								(T[j.T.x][j.T.y + 250]) = (T[j.T.x][j.T.y]);
								(T[j.T.x][j.T.y]) = new Air(j.T.x, j.T.y);
								j.T.y = j.T.y + 250;
							}
							else if (b[5] == 1 && !(T[j.T.x][j.T.y - 1]).blocksPath) {
								(T[j.T.x][j.T.y -1]) = (T[j.T.x][j.T.y]);
								(T[j.T.x][j.T.y]) = new Air(j.T.x, j.T.y);
								j.T.y--;
							}
							else if (b[6] == 1 && !(T[j.T.x][j.T.y + 1]).blocksPath) {
								(T[j.T.x][j.T.y + 1]) = (T[j.T.x][j.T.y]);
								(T[j.T.x][j.T.y]) = new Air(j.T.x, j.T.y);
								j.T.y++;
							}
							break;
						case (402):
							int foodArea = 0;
							if((T[j.T.x + 1][j.T.y]).isEdible){
								foodArea++;
								if((T[j.T.x + 1][j.T.y]).identifier == 209) {
									(T[j.T.x + 1][j.T.y]).Pain++;
								}
							}
							if((T[j.T.x - 1][j.T.y]).isEdible) {
								foodArea++;
								if((T[j.T.x - 1][j.T.y]).identifier == 209) {
									(T[j.T.x - 1][j.T.y]).Pain++;
								}
							}
							if((T[j.T.x][j.T.y - 250]).isEdible) {
								foodArea++;
								if((T[j.T.x][j.T.y - 250]).identifier == 209) {
									(T[j.T.x][j.T.y - 250]).Pain++;
								}
							}
							if((T[j.T.x][j.T.y + 250]).isEdible) {
								foodArea++;
								if((T[j.T.x][j.T.y + 250]).identifier == 209) {
									(T[j.T.x][j.T.y + 250]).Pain++;
								}
							}
							if((T[j.T.x][j.T.y - 1]).isEdible) {
								foodArea++;
								if((T[j.T.x][j.T.y - 1]).identifier == 209) {
									(T[j.T.x][j.T.y - 1]).Pain++;
								}
							}
							if((T[j.T.x][j.T.y + 1]).isEdible) {
								foodArea++;
								if((T[j.T.x][j.T.y + 1]).identifier == 209) {
									(T[j.T.x][j.T.y + 1]).Pain++;
								}
							}
							j.T.Hunger = j.T.Hunger + foodArea;
							AL.set(It, j);
							break;
						case (403):
							if (j.T.Hunger > 2) {
								j.T.Hunger = j.T.Hunger - 2;
								j.T.Pain = j.T.Pain - 10;
								AL.set(It, j);
							}
							break;
//						case (404):
//						Quit game
//							break;
						case (405):
							break;
						case (406):
							break;
						case (407):
							break;
						case (408):
							break;
						case (409):
							break;
						}
						j.setOut(toIntPrimitiveArray(I));
					}
					It++;
				}
			}
		} else {
			System.out.println(
					"Run with 'java -jar Umwelten-Server <port>' Where port is the port you want to run the server on");
		}
	}
	public static int[] toIntPrimitiveArray(ArrayList<Integer> L) {
		Iterator I = L.iterator();
		int[] returning = new int[L.size()];
		int k = 0;
		while(I.hasNext()) {
			returning[k] = (int)I.next();
			k++;
		}
		return null;
	}
}
