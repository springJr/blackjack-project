package practice.blackjack.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.Getter;
import practice.blackjack.domain.card.Card;
import practice.blackjack.domain.card.CardDummy;

@Getter
public class BlackJackGame {
    private Long gameId;
    private boolean isBlackJack = false;
    private List<Card> cards = new ArrayList<>();

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public int getCardsSum() {
        return cards.stream()
                .mapToInt(card -> card.getCardValue())
                .sum();
    }

    public boolean containAce() {
        Optional<Card> any = cards.stream()
                .filter(card -> card.getCardValue() == 11)
                .findAny();
        return true; // 미완성
    }

    // 블랙잭인지 확인
    public void isBlackJack() {
        if(getCardsSum() == 21){
            this.isBlackJack = true;
        }
    }

    public void addCard() {
        Card card = CardDummy.drawCard();
        cards.add(card);
    }

    public int getSize() {
        return cards.size();
    }
}
