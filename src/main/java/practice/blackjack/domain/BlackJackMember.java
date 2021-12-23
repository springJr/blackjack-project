package practice.blackjack.domain;

import lombok.Getter;
import practice.blackjack.domain.card.Card;
import practice.blackjack.domain.card.CardDummy;
import practice.blackjack.domain.card.Cards;


public interface BlackJackMember {
	void addCard();
	void isBust();
	void isBlackjack();
	void shouldGetCard(); //return boolean
	Cards getCards();

}
