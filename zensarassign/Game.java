package zensarassign;

import java.util.*;

public class Game {
	Scanner sc = new Scanner(System.in);
	DeckPatta dk;
	static List<Player> players = new ArrayList<Player>();
	static ArrayList<Integer> playerRank = new ArrayList();
	
	public Game(DeckPatta dk) {
		super();
		this.dk = dk;
	}

	public void dispatchPatta() {
		int randomVar = 0;
		for (Player p : players) {
			ArrayList hand = new ArrayList<Patta>();

			for (int i = 0; i < 3; i++) { // each player has 3 patta/card
				hand.add(dk.getPatta().get(randomVar));
				randomVar++;
			}
			p.setHand(hand);
		}
	}

	public Player getWinner() {
		System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________\n");
		System.out.println("\t\t1.Normal Rule");
		System.out.println("\t\t2.Any card/patta Jocker");
		System.out.println("\t\t3.Low Card/patta Joker");
		System.out.println("\t\t4.High Card/patta Joker");
		System.out.println("\n\t\tPress any key to exit the game");

		System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________\n");
		System.out.println("Select the mode of the game");
		int ch = sc.nextInt();

		switch (ch) {
		case 1:
			System.out.println("By Normal Rule");
			normalRule(players);
//			displayWinner(players);
			break;

		default:
			System.out.println("exit");
			System.exit(0);
		}

		return players.get(0);

	}

	private static void normalRule(List<Player> players) {
		if (checkSameNumber(players)) {
			System.out.println("\t\tSame number card occured");
		}
		else if (checkSequenceWithColor(players))
			System.out.println("\t\tSame sequence colors occured");
		else if (checkSameSequenceWithoutColor(players))
			System.out.println("\t\tSame sequence without color occured");
		else if (checkSameColor(players))
			System.out.println("\t\tsame color cards occured");
//		else if (checkPair(players))
//			System.out.println("pair");
		else
			highestCardWinner(players);
//		int count=0;
//		for (Player p : players) {		
//			count+=1;
//			p.pname="Player".concat(String.valueOf(count));
//			System.out.println(p.pname);
//			p.rank=isHighestCardWinner(players);
//			playerRank.add(p.rank);
//			System.out.println(p.rank);
//	}
//		displayWinner(players);
	}

	public static boolean checkSameNumber(List<Player> players) {			//check the card/pattas are same or not
		for (Player p : players) {
			ArrayList<Patta> card = (ArrayList<Patta>) p.hand;
			HashSet<PatteDesc> set = new HashSet();
			for (Patta patta : card) {
				set.add(patta.patteDesc);
			}
			if (set.size() == 1) {
				p.rank = 1;
				return true;
			}
			
		}
		return false;
	}

	public static boolean checkSequenceWithColor(List<Player> players) {		//check sequence with color
		for (Player p : players) {
			ArrayList<Patta> card1 = (ArrayList<Patta>) p.hand;
			HashSet<PatteSuits> sset = new HashSet();
			ArrayList<PatteDesc> pd = new ArrayList<PatteDesc>();

			for (Patta patta : card1) {
				sset.add(patta.patteSuits);
				pd.add(patta.patteDesc);
			}
			if (sset.size() == 1) {
				Collections.sort(pd);
				boolean isSequence = true;
				for (int i = 0; i < pd.size() - 1; i++) {
					if (pd.get(i + 1).getNameOfPatta() - pd.get(i).getNameOfPatta() != 1) {
						isSequence = false;
					}
				}
				if (isSequence) {
					p.rank = 2;
					return true;
				}
			}
			
		}
		return false;
	}

	public static boolean checkSameSequenceWithoutColor(List<Player> players) {			//check sequence without color
		for (Player p : players) {
			ArrayList<Patta> card2 = (ArrayList<Patta>) p.hand;
			ArrayList<PatteDesc> pd1 = new ArrayList<PatteDesc>();

			for (Patta patta : card2) {
				pd1.add(patta.patteDesc);
			}
			Collections.sort(pd1);
			boolean isSequence = true;

			for (int i = 0; i < pd1.size() - 1; i++) {
				if (pd1.get(i + 1).getNameOfPatta() - pd1.get(i).getNameOfPatta() != 1) {
					isSequence = false;
				}
			}
			if (isSequence) {
				p.rank = 3;
				return true;
			}
			
			
		}
		return false;
	}

	public static boolean checkSameColor(List<Player> players) {						//check same color 
		for (Player p : players) {		
			ArrayList<Patta> card3 = (ArrayList<Patta>) p.hand;
			HashSet<PatteSuits> suitset = new HashSet();
			for (Patta patta : card3) {
				suitset.add(patta.patteSuits);
			}
			if (suitset.size() == 1) {
				p.rank = 1;
				return true;
			}
		
		}
		return false;
	}

	public static boolean checkPair(List<Player> players) {										//check the pair of the patteDesc
		for (Player p : players) {
			ArrayList<Patta> card4 = (ArrayList<Patta>) p.hand;
			HashSet<PatteDesc> pattaDesc = new HashSet();
			for (Patta patta : card4) {
				if(!pattaDesc.contains(card4))
				{
					
				}
				return true;
			}
			
		}
		return false;
	}

	public static void highestCardWinner(List<Player> players) {	//check the highest score player
		ArrayList<Integer> res = new ArrayList<Integer>();int maxVal=0;
		for (Player p : players) {
			ArrayList<Patta> card5 = (ArrayList<Patta>) p.hand;
			ArrayList<PatteDesc> pd5 = new ArrayList<PatteDesc>();
			
			for (Patta patta : card5) {
				pd5.add(patta.patteDesc);
			}
		
			System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________\n");
			System.out.println("\t\tPlayer : "+p.getPname()+"\n");
			System.out.println("\t\t"+pd5);
			
			int sum = 0;
			for (int i = 0; i < pd5.size(); i++) {
				sum = sum + pd5.get(i).nameOfPatte;
			}
			System.out.println("\t\tTotal Score : "+sum+"\n");
			res.add(sum);
			
		}
		 maxVal=Collections.max(res);
		 System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________\n");
		 System.out.println("\t\tHighest card number is : "+maxVal+"\n");
//			System.out.println(maxVal);
//		int sum=0;
//		for(int i=0;i<pd5.size();i++)
//		{
//			sum=sum+pd5.get(i).nameOfPatte;
//		}
//		return sum;
	}
	
//	public static void displayWinner(List<Player> players) {
//		int max=0;
//		String player="";
//		for(Player p:players)
//		{
//			System.out.println("Rank: "+p.rank);
//			if(p.rank>max)
//			{
//				max=p.rank;
//				player=p.pname;
//			}
//			System.out.println(p.rank);
//		}
//		System.out.println("Winner is: "+player+" with rank "+max);
//	}
}
