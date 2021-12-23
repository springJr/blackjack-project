package practice.blackjack.domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDummy {

	private static List<Card> cardList = makeDummy(); //카드 더미 생성후 섞는 과정
	private static int cardIndex = 0; //카드 더미에서 뽑는 순서


	private static List<Card> makeDummy() {
		List<Card> cardList = new ArrayList<>();
		CardSymbol[] symbols = CardSymbol.values();
		CardValue[] values = CardValue.values();
		for (CardSymbol symbol : symbols) {
			for (CardValue value : values) {
				Card card = new Card(symbol, value);
				cardList.add(card);
			}
		}
		Collections.shuffle(cardList);
		return cardList;
	}

	public static Card drawCard() {
		return cardList.get(cardIndex++);
	}
}
