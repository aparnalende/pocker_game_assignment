package zensarassign;

public enum PatteDesc {
	TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13),
	ACE(14);

	int nameOfPatte;

	PatteDesc(int nameOfPatte) {
		this.nameOfPatte = nameOfPatte;
	}

	public int getNameOfPatta() {
		return nameOfPatte;
	}
}
