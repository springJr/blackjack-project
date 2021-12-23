package practice.blackjack.domain;

import lombok.Getter;
import lombok.Setter;
import practice.blackjack.domain.card.Cards;

@Getter
@Setter
public class Player extends BlackJackMember {
	private String userName;
	private Sexs userSex;
	private Cards playerCards;
	@Override
	void shouldGetCard() {

	}
}
