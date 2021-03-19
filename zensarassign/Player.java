package zensarassign;

import java.util.*;

public class Player {

	String pname;
	int rank = 0;
	int cardTotal = 0;

	List<Patta> hand;

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
