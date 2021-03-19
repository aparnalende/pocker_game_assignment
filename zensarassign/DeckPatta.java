package zensarassign;

import java.util.*;

public class DeckPatta {

	// create a list of patta/card
	private List<Patta> pattas = new ArrayList<Patta>();

	// create a default constructor
	public DeckPatta() {
		for (PatteSuits patteSuits : PatteSuits.values())// iterate suits of patta using enhanced for loop
		{
			for (PatteDesc patteDesc : PatteDesc.values())// iterate desc of patta using enhanced for loop
			{
				Patta patta = new Patta(patteSuits, patteDesc);// call parameterised constructor of Patta
				pattas.add(patta);
			}
		}
	}

	public List<Patta> getPatta() // getter of Patta list
	{
		return pattas;
	}

	public void shuffleDeckPatta() // shuffling a all pattas using suffle method of Collection class
	{
		Collections.shuffle(pattas);
	}

	public void displayPatta() // Display all the set of patta
	{
		System.out.println(pattas.size());
		System.out.println(pattas);
	}

}
