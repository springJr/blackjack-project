package practice.blackjack.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import practice.blackjack.domain.card.Cards;

@Slf4j
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
		log.info("playerCard size={}", playerCards.getSize());
	}
}


