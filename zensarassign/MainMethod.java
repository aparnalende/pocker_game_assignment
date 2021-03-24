package zensarassign;

import java.util.*;

public class MainMethod {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
	
		System.out.println("How many players you want?"); // accept number of players from users
		int p = sc.nextInt();

		String pname;
		System.out.println("Enter names of players: ");

		for (int i = 0; i < p; i++) {
			pname = sc.next();
			Game.players.add(new Player(pname)); // we add the player name into the Game list from players
		}
		
		DeckPatta dk = new DeckPatta(); // creating a object of DeckPatta
		Game game = new Game(dk); // pass the object to the Game class

		game.dk.shuffleDeckPatta(); // shuffle that all set of patta randomly

		System.out.println("\nAfter Shuffling() :");
		game.dk.displayPatta();
		game.dispatchPatta(); // here we distribute the 3 pattas from the given accepted players

		System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________\n");
		System.out.println("After card distribution :");
		for (Player player : game.players) // after distributed the players with set of patta
		{
			System.out.println("\t\tPlayer :"+player.pname);
			System.out.println("\t\t "+player.getHand()+"\n");
		}

		game.getWinner();
	}

}
