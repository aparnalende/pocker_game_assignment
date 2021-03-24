package zensarassign;
public class Patta {

	PatteSuits patteSuits; // suits of patte in enum form
	PatteDesc patteDesc; // desc of patte in enum form

	public Patta() {
	}

	public Patta(PatteSuits patteSuits, PatteDesc patteDesc) {
		this.patteSuits = patteSuits;
		this.patteDesc = patteDesc;
	}

	public PatteSuits getPatteSuits() {
		return patteSuits; // 4
	}

	public PatteDesc getPatteDesc() {
		return patteDesc; // 14
	}

	@Override
	public String toString() {
		return "" + patteSuits + " " + "of" + " " + patteDesc + "";
	}

}
