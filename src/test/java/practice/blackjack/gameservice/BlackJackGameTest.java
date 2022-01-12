package practice.blackjack.gameservice;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import practice.blackjack.domain.game.BlackJackGame;
import practice.blackjack.domain.card.Card;
import practice.blackjack.domain.card.CardSymbol;
import practice.blackjack.domain.card.CardValue;

public class BlackJackGameTest {

	@Test
	void isBustTest() {
		//given
		BlackJackGame blackJackGame = new BlackJackGame();
		Card card1 = new Card(CardSymbol.SPADE, CardValue.TEN);
		Card card2 = new Card(CardSymbol.SPADE, CardValue.TEN);
		Card card3 = new Card(CardSymbol.SPADE, CardValue.TEN);

		//when
		blackJackGame.addCard(card1);
		blackJackGame.addCard(card2);
		blackJackGame.addCard(card3);

		//then
		assertThat(blackJackGame.isBust()).isTrue();
	}

	@Test
	void isBlackJack() {
		//given
		BlackJackGame blackJackGame = new BlackJackGame();
		Card card1 = new Card(CardSymbol.HEART, CardValue.TEN);
		Card card2 = new Card(CardSymbol.SPADE, CardValue.A);

		//when
		blackJackGame.addCard(card1);
		blackJackGame.addCard(card2);

		//then
		assertThat(blackJackGame.isBlackJack()).isTrue();
	}

	@Test
	void isAceFlexible_1() {
		//given
		BlackJackGame blackJackGame = new BlackJackGame();
		Card card1 = new Card(CardSymbol.HEART, CardValue.A);
		Card card2 = new Card(CardSymbol.SPADE, CardValue.A);

		//when
		blackJackGame.addCard(card1);
		blackJackGame.addCard(card2);

		//then
		assertThat(blackJackGame.getCardsSum()).isEqualTo(12);
	}

	@Test
	void isAceFlexible_2() {
		//given
		BlackJackGame blackJackGame = new BlackJackGame();
		Card card1 = new Card(CardSymbol.HEART, CardValue.A);
		Card card2 = new Card(CardSymbol.SPADE, CardValue.A);
		Card card3 = new Card(CardSymbol.SPADE, CardValue.A);

		//when
		blackJackGame.addCard(card1);
		blackJackGame.addCard(card2);
		blackJackGame.addCard(card3);

		//then
		assertThat(blackJackGame.getCardsSum()).isEqualTo(13);
	}
}
