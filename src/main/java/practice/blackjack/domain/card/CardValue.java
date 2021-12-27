package practice.blackjack.domain.card;

import lombok.Getter;

@Getter
public enum CardValue {
	A(11, "ACE"),
	TWO(2, "2"),
	THREE(3, "3"),
	FOUR(4, "4"),
	FIVE(5, "5"),
	SIX(6, "6"),
	SEVEN(7, "7"),
	EIGHT(8, "8"),
	NINE(9, "9"),
	TEN(10, "10"),
	JACK(10, "J"),
	QUEEN(10, "Q"),
	KING(10, "K");

	private int value;
	private String message;

	CardValue(int value, String message) {
		this.value = value;
		this.message = message;
	}
}
