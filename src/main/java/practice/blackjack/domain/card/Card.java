package practice.blackjack.domain.card;

public class Card {
	CardSymbol cardSymbol;
	CardValue cardValue;

	public Card(CardSymbol cardSymbol, CardValue cardValue) {
		this.cardSymbol = cardSymbol;
		this.cardValue = cardValue;
	}

	public String getCardSymbol() {
		return cardSymbol.getSymbolEmoji();
	}

	public int getCardValue() {
		return cardValue.getValue();
	}

	public String getCardMessage() {
		return cardValue.getMessage();
	}
}

