package practice.blackjack.domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDummy {
	private static List<Card> cardList = new ArrayList<>();

	public static void makeDummy() {
		CardSymbol[] symbols = CardSymbol.values();
		CardValue[] values = CardValue.values();
		for (CardSymbol symbol : symbols) {
			for (CardValue value : values) {
				Card card = new Card(symbol, value);
				cardList.add(card);
			}
		}
	}

	public static void shuffleCards() {
		Collections.shuffle(cardList);
	}
}
