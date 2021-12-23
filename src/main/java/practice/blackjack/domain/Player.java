package practice.blackjack.domain;

import lombok.Getter;
import practice.blackjack.domain.card.Cards;

public class Player implements BlackJackMember {
	Cards playerCards = new Cards();

	@Override
	public void shouldGetCard() {

	}

	@Override
	public Cards getCards() {
		return playerCards;
	}

	public void addCard() {
		playerCards.addCard();
	}

	@Override
	public void isBust() {

	}

	@Override
	public void isBlackjack() {

	}
}
