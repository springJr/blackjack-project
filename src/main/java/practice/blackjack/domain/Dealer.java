package practice.blackjack.domain;

import practice.blackjack.domain.card.Cards;

public class Dealer implements BlackJackMember {
	Cards dealerCards = new Cards();

	@Override
	public void shouldGetCard() {

	}

	@Override
	public Cards getCards() {
		return dealerCards;
	}

	public void addCard() {
		dealerCards.addCard();
	}

	@Override
	public void isBust() {

	}

	@Override
	public void isBlackjack() {

	}
}
