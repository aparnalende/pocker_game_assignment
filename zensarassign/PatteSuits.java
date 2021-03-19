package zensarassign;

public enum PatteSuits {
	HEARTS(1), CLUB(2), DIAMONDS(3), SPADES(4);

	private int suitName;

	private PatteSuits(int suitName) {
		this.suitName = suitName;
	}

	public int getSuitName() {
		return suitName;
	}
}
