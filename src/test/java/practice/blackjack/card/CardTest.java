package practice.blackjack.card;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import practice.blackjack.domain.card.Card;
import practice.blackjack.domain.card.CardDummy;

public class CardTest {

	@Test
	void drawCardTest() {
		//given


		//when
		Card card1 = CardDummy.drawCard();
		Card card2 = CardDummy.drawCard();

		//then
		assertThat(card1).isNotEqualTo(card2);
	}
}
