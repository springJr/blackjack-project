package practice.blackjack.domain.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.Getter;

@Getter
public class Cards {
    List<Card> cards = new ArrayList<>();

    public int getCardsSum() {
        return cards.stream()
                .mapToInt(card -> card.cardValue.getValue())
                .sum();
    }

    public boolean containAce() {
        Optional<Card> any = cards.stream()
                .filter(card -> card.cardValue.getValue() == 11)
                .findAny();
        return true; // 미완성
    }

    public void addCard() {
        Card card = CardDummy.drawCard();
        cards.add(card);
    }

    public int getSize() {
        return cards.size();
    }
}
