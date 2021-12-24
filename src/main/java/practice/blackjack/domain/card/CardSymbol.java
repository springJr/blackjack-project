package practice.blackjack.domain.card;

public enum CardSymbol {
	SPADE("♠️"),
	DIAMOND("♦️"),
	HEART("♥️"),
	CLUB("♣️");

	private String symbolEmoji;

	CardSymbol(String symbolEmoji) {
		this.symbolEmoji = symbolEmoji;
	}

	public String getSymbolEmoji() {
		return symbolEmoji;
	}
}
