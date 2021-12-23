package practice.blackjack.domain;

import lombok.Getter;
import lombok.Setter;
import practice.blackjack.domain.card.Cards;

@Getter
@Setter
public class Player implements BlackJackMember {
	private String userName;
	private Sexs userSex;
	private Cards playerCards = new Cards();

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
}


