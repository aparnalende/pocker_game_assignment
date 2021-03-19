package zensarassign;

import java.util.*;

public class MainMethod {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int score=0;
		
		System.out.println("How many players you want?"); // accept number of players from users
		int p = sc.nextInt();

		String pname;
		System.out.println("Enter names of player");

		for (int i = 0; i < p; i++) {
			pname = sc.next();
			Game.players.add(new Player(pname)); // we add the player name into the Game list from players
		}
		DeckPatta dk = new DeckPatta(); // creating a object of DeckPatta
		Game game = new Game(dk); // pass the object to the Game class

		game.dk.shuffleDeckPatta(); // shuffle that all set of patta randomly

		System.out.println("After Shuffling()");
		game.dk.displayPatta();
		game.dispatchPatta(); // here we distribute the 3 pattas from the given accepted players

		for (Player player : game.players) // after distributed the players with set of patta
		{
			System.out.println(player.pname);
			System.out.println(player.getHand());
		}

		game.getWinner();
	}

}
