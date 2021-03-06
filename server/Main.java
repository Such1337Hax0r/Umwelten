package server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Main {
	public static ArrayList<ClientHandler> AL = new ArrayList<ClientHandler>();
	static Thing[][] T = new Thing[500][500];
	static ArrayList<String> Str = new ArrayList<String>();
/*
 * OFFICIAL DIRECTION CODE:
 *    0                    N
 *  3 P 1   Compass rose:W   E 
 *    2                    S
 *  (P = player)
 *  Up is 4, down is 5, but bobmonkeywarts thinks this should mostly be a 2D game
 *  because such1337hax0r's grid system of having a 3d game with a 2d array is really 
 *  annoying but he doesn't want to go into such1337hax0r's sphagetti code and change it.
 *  If you change it bobmonkeywarts will be forever in debt to you.
 *  
 *  Note: The random Strings in the System.out.printlns are for debugging, that's why it's constantly printing YOUTUBE YOUTUBE YOUTUBE YOUTUBE.
 */
	public static void main(String Args[]) throws IOException {
		if (!(Args.length < 1)) {
			System.out.println("Welcome to Umwelten sever, Enter quit to quit");
			int port = Integer.parseInt(Args[0]);
			ServerSocket s = new ServerSocket(port);
			Scanner S = new Scanner(System.in);
			System.out.println("HGFS");
			int x = 0;
			for (Thing[] thi : T) {

				for (int i = 0; i < thi.length; i++) {
					thi[i] = new Air(x, i);
				}
				if (x < 50) {
					for (int i = 0; i < thi.length; i++) {
						thi[i] = new Stone(x, i);
						System.out.println("FHDSK");
					}

				}
				T[x] = thi;
				x++;
				System.out.println("JKLG");
			}
			while (true) {
				System.out.println("YOUTUBE");
				Socket Client = s.accept();
				System.out.println("YOUTUBE");
				ClientHandler c = new ClientHandler(Client);
				System.out.println("YOUTUBE");
				if (!c.equals(null)) {
					c.run();
				}
				System.out.println("YOUTUBE");
				char c1 = (char) c.getIn()[0];
				char c2 = (char) c.getIn()[1];
				char c3 = (char) c.getIn()[2];
				char c4 = (char) c.getIn()[3];
				System.out.println("YOUTUBE");
				String J = new String("" + c1 + c2 + c3 + c4);
				System.out.println("YOUTUBE");
				c.setPlayer(T, J);
				if (S.next().equals("quit")) {
					s.close();
					S.close();
					System.gc();
					System.exit(1);
					break;
				}
				int currentCode = 0;
				int It = 0;
				System.out.println("FHKL");
				ArrayList<Integer> I = new ArrayList<Integer>();
				String toSend = "";
				for (ClientHandler j : AL) {
					// int Oldy = AL.get(It).T.y;
					// int Oldx = AL.get(It).T.x;
					// (T[Oldx][Oldy]) = new Air(Oldx, Oldy);
					// (T[j.T.x][j.T.y]) = j.T;
					int[] b = j.getIn();
					currentCode = b[0];
					switch (currentCode) {
					case (101):
						/*
						Old vision code, with fog:
						I.add((T[j.T.x + 1][j.T.y]).identifier);
						I.add((T[j.T.x - 1][j.T.y]).identifier);
						I.add((T[j.T.x][j.T.y - 250]).identifier);
						I.add((T[j.T.x][j.T.y + 250]).identifier);
						I.add((T[j.T.x][j.T.y - 1]).identifier);
						I.add((T[j.T.x][j.T.y + 1]).identifier);
						System.out.println("101");
						*/
						//New vision code written by bobmonkeywarts:
						int[] vision = vision(j.T);
						for(int i = 0; i < vision.length; i ++) {
							I.add(vision[i]);
						}
						break;
					case (102):
						int heatArea = 0;
						if ((T[j.T.x + 1][j.T.y]).emitsHeat) {
							heatArea++;
						}
						if ((T[j.T.x - 1][j.T.y]).emitsHeat) {
							heatArea++;
						}
						if ((T[j.T.x][j.T.y - 250]).emitsHeat) {
							heatArea++;
						}
						if ((T[j.T.x][j.T.y + 250]).emitsHeat) {
							heatArea++;
						}
						if ((T[j.T.x][j.T.y - 1]).emitsHeat) {
							heatArea++;
						}
						if ((T[j.T.x][j.T.y + 1]).emitsHeat) {
							heatArea++;
						}
						I.add(heatArea);
						System.out.println("102");
						break;
					case (103):
						int pressArea = 0;
						if ((T[j.T.x + 1][j.T.y]).emitsHeat) {
							pressArea++;
						}
						if ((T[j.T.x - 1][j.T.y]).emitsHeat) {
							pressArea++;
						}
						if ((T[j.T.x][j.T.y - 250]).emitsHeat) {
							pressArea++;
						}
						if ((T[j.T.x][j.T.y + 250]).emitsHeat) {
							pressArea++;
						}
						if ((T[j.T.x][j.T.y - 1]).emitsHeat) {
							pressArea++;
						}
						if ((T[j.T.x][j.T.y + 1]).emitsHeat) {
							pressArea++;
						}
						I.add(pressArea);
						System.out.println("103");
						break;
					case (104):
						// Hearing
						break;
					case (105):
						for (int jkl = 0; jkl < toSend.length(); jkl++) {
							I.add((int) toSend.charAt(jkl));
						}
						break;
					case (106):
						int purpArea = 0;
						if ((T[j.T.x + 1][j.T.y]).emitsHeat) {
							purpArea++;
						}
						if ((T[j.T.x - 1][j.T.y]).emitsHeat) {
							purpArea++;
						}
						if ((T[j.T.x][j.T.y - 250]).emitsHeat) {
							purpArea++;
						}
						if ((T[j.T.x][j.T.y + 250]).emitsHeat) {
							purpArea++;
						}
						if ((T[j.T.x][j.T.y - 1]).emitsHeat) {
							purpArea++;
						}
						if ((T[j.T.x][j.T.y + 1]).emitsHeat) {
							purpArea++;
						}
						I.add(purpArea);
						System.out.println("106");
						break;
					case (107):
						I.add(j.T.Pain);
						System.out.println("107");
						break;
					case (108):
						I.add(j.T.Hunger);
						System.out.println("108");
						break;
					// case (109):
					// break;
					case (401):
						if (b[1] == 1 && !(T[j.T.x + 1][j.T.y].blocksPath)) {
							(T[j.T.x + 1][j.T.y]) = (T[j.T.x][j.T.y]);
							(T[j.T.x][j.T.y]) = new Air(j.T.x, j.T.y);
							j.T.x++;
						} else if (b[2] == 1 && !(T[j.T.x - 1][j.T.y]).blocksPath) {
							(T[j.T.x - 1][j.T.y]) = (T[j.T.x][j.T.y]);
							(T[j.T.x][j.T.y]) = new Air(j.T.x, j.T.y);
							j.T.x--;
						} else if (b[3] == 1 && !(T[j.T.x][j.T.y - 250]).blocksPath) {
							(T[j.T.x][j.T.y - 250]) = (T[j.T.x][j.T.y]);
							(T[j.T.x][j.T.y]) = new Air(j.T.x, j.T.y);
							j.T.y = j.T.y - 250;
						} else if (b[4] == 1 && !(T[j.T.x][j.T.y + 250]).blocksPath) {
							(T[j.T.x][j.T.y + 250]) = (T[j.T.x][j.T.y]);
							(T[j.T.x][j.T.y]) = new Air(j.T.x, j.T.y);
							j.T.y = j.T.y + 250;
						} else if (b[5] == 1 && !(T[j.T.x][j.T.y - 1]).blocksPath) {
							(T[j.T.x][j.T.y - 1]) = (T[j.T.x][j.T.y]);
							(T[j.T.x][j.T.y]) = new Air(j.T.x, j.T.y);
							j.T.y--;
						} else if (b[6] == 1 && !(T[j.T.x][j.T.y + 1]).blocksPath) {
							(T[j.T.x][j.T.y + 1]) = (T[j.T.x][j.T.y]);
							(T[j.T.x][j.T.y]) = new Air(j.T.x, j.T.y);
							j.T.y++;
						}
						if(isInDanger(j.T)) j.T.pain += 10;
						System.out.println("401");
						break;
					case (402):
						int foodArea = 0;
						if ((T[j.T.x + 1][j.T.y]).isEdible) {
							foodArea++;
							if ((T[j.T.x + 1][j.T.y]).identifier == 209) {
								(T[j.T.x + 1][j.T.y]).Pain++;
							}
						}
						if ((T[j.T.x - 1][j.T.y]).isEdible) {
							foodArea++;
							if ((T[j.T.x - 1][j.T.y]).identifier == 209) {
								(T[j.T.x - 1][j.T.y]).Pain++;
							}
						}
						if ((T[j.T.x][j.T.y - 250]).isEdible) {
							foodArea++;
							if ((T[j.T.x][j.T.y - 250]).identifier == 209) {
								(T[j.T.x][j.T.y - 250]).Pain++;
							}
						}
						if ((T[j.T.x][j.T.y + 250]).isEdible) {
							foodArea++;
							if ((T[j.T.x][j.T.y + 250]).identifier == 209) {
								(T[j.T.x][j.T.y + 250]).Pain++;
							}
						}
						if ((T[j.T.x][j.T.y - 1]).isEdible) {
							foodArea++;
							if ((T[j.T.x][j.T.y - 1]).identifier == 209) {
								(T[j.T.x][j.T.y - 1]).Pain++;
							}
						}
						if ((T[j.T.x][j.T.y + 1]).isEdible) {
							foodArea++;
							if ((T[j.T.x][j.T.y + 1]).identifier == 209) {
								(T[j.T.x][j.T.y + 1]).Pain++;
							}
						}
						j.T.Hunger = j.T.Hunger + foodArea;
						AL.set(It, j);
						System.out.println("402");
						break;
					case (403):
						if (j.T.Hunger > 2) {
							j.T.Hunger = j.T.Hunger - 2;
							j.T.Pain = j.T.Pain - 10;
							AL.set(It, j);
						}
						System.out.println("403");
						break;
					// case (404):
					// Quit game
					// break;
					case (405):
						for (int jkl = 1; jkl < (b.length - 1); jkl++) {
							char[] toSendChar = toSend.toCharArray();
							toSendChar[jkl - 1] = ((char) b[jkl]);
							toSend = toSendChar.toString();
						}
						System.out.println(405);
						break;
					case (406):
						boolean mashed = mashHeadAgainstRock(j.T, b[1]);
						toSend = mashed?1:-1;
						System.out.println(406);
						break;
					case (407):
						break;
					case (408):
						break;
					case (409):
						break;
					default:
						System.out.println("GHJK");
						break;
					}
					System.out.println("1");
					j.setOut(toIntPrimitiveArray(I));
				}
				Str.add(toSend);
				System.out.println("Debugging!");
				It++;
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
		while (I.hasNext()) {
			returning[k] = (int) I.next();
			k++;
		}
		return null;
	}
	//Mashes head against rock. If there is a rock nearby, p.pain will increment by hardness and returns true. Otherwise, returns false.
	public static boolean mashHeadAgainstRock (Player p, int hardness) {
		int x = p.x;
		int y = p.y;
		if(T[x][y+1].identifier==203 || T[x][y-1].identifier==203 || T[x+1][y].identifier==203 || T[x-1][y].identifier==203) {
			p.pain += hardness;
			return true;
		}
		return false;
	}
	//Returns an int[] of what you're seeing. pos 0 = north, 1 = east, etc.
	public static int[] vision(Player p) {
		int[] toReturn = new int[4];
		for(int i = 0; i < 4; i ++) {
			toReturn[i] = seeInDirection(p.x, p.y, i);
		}
	}
	//Helper method for vision(Player), don't use this. Direction code stays the same.
	//Precondition: direction is an int 0-4.
	public static int seeInDirection(x, y, int direction) {
		if(direction == 0) {
			if(y==T[x].length-1) return 205;
				if(T[x][y+1] == 205) {
				return seeInDirection(x, y+1, direction);
			}
			return T[x][y+1];
		}
		if(direction == 1) {
			if(x==T.length-1) return 205;
			if(T[x+1][y] == 205) {
				return seeInDirection(x+1, y, direction);
			}
			return T[x+1][y];
		}
		if(direction == 2) {
			if(y==0) return 205;
			if(T[x][y-1] == 205) {
				return seeInDirection(x, y-1, direction);
			}
			return T[x][y-1];
		}
		if(direction == 3) {
			if(x==0) return 205;
			if(T[x-1][y] == 205) {
				return seeInDirection(x-1, y, direction);
			}
			return T[x][y-1];
		}
		return -1;
	}
	//Generates a 250x500x250 map.(500 is Y) NOT FINISHED
	public static int[][][] generateMap() {
		int fakeX;
		int fakeY;
		//50 layers of stone on the bottom:
		for(int x = 0; x < xLength; x ++) {
			for(int y = 0; y<50; y ++) {
				for(int z = 0; z<zLength; z++) {
					fakeX = xyztoxy(x, y, z)[0];
					T[fakeX][y] = new Stone(fakeX, fakeY);
				}
			}
		}
		//3 layers of dirt on top of that stone:
		for(int x = 0; x < xLength; x ++) {
			for(int y = 0; y<3; y ++) {
				for(int z = 0; z<zLength; z++) {
					fakeX = xyztoxy(x, y, z)[0];
					T[fakeX][y] = new Dirt(fakeX, fakeY);
				}
			}
		}
		//Lays out trees:
		for(int x = 0; x < 250; i ++) {
			for(int z = 0; z < 250; z ++) {
				boolean toPlant = Math.random()<0.2;
				fakeZ = 
				if(toPlant) T[]
			}
		}
		
	}
	
	
	//Returns true if p is touching something toxic.
	public static boolean isInDanger(Player p) {
		ArraList<Thing> touching = new ArrayList<Thing>;
		touching.add((T[j.T.x + 1][j.T.y]));
		touching.add((T[j.T.x - 1][j.T.y]));
		touching.add((T[j.T.x][j.T.y - 250]));
		touching.add((T[j.T.x][j.T.y + 250]));
		touching.add((T[j.T.x][j.T.y - 1]));
		touching.add((T[j.T.x][j.T.y + 1]));
		for(int i = 0; i < touching.size(); i ++) {
			if(touching.get(i).isToxic) return true;
		}
		return false;
	}
	
}
