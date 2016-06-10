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
					T[x] = thi;
				}
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
				
				c.T = new Player(J, 51, 250);
				if (S.next().equals("quit")) {
					s.close();
					break;
				}
				int currentCode = 0;
				ArrayList<Integer> I = new ArrayList<Integer>();
				for (ClientHandler j : AL) {
					int[] b = j.getIn();
					for (int i = 0; i < b.length; i++) {
						currentCode = b[0];
						switch (currentCode) {
						case (101):
							
							break;
						case (102):
							break;
						case (103):
							break;
						case (104):
							break;
						case (105):
							break;
						case (106):
							break;
						case (107):
							break;
						case (108):
							break;
						case (109):
							break;
						case (401):
							break;
						case (402):
							break;
						case (403):
							break;
						case (404):
							break;
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
					}
				}
			}
		} else {
			System.out.println(
					"Run with 'java -jar Umwelten-Server <port>' Where port is the port you want to run the server on");
		}
	}
}
