package zensarassign;

import java.util.*;
	
public class Player {																	//create a separate player class 																

	String pname;																		  //declare player name 
	int rank=0;

	List<Patta> hand;																	//create a list object of Patta class								

	public Player(String pname) {
		this.pname = pname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public List<Patta> getHand() {
		return hand;
	}

	public void setHand(List<Patta> hand) {
		this.hand = hand;
	}

	public String toString() {
		return this.pname + this.hand;
	}
}
