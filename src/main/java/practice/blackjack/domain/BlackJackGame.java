package practice.blackjack.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.Getter;
import practice.blackjack.domain.card.Card;
import practice.blackjack.domain.card.CardDummy;

@Getter
public class BlackJackGame {
    private Long gameId;
    private boolean isFinished = false;
    private List<Card> cards = new ArrayList<>();

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public int getCardsSum() {
        int cardSum = cards.stream()
            .mapToInt(card -> card.getCardValue())
            .sum();
        int aceAmount = countAce();
        while (cardSum > 21 && aceAmount > 0) {
            cardSum -= 10;
            aceAmount -= 1;
        }
        return cardSum;
    }

    // 블랙잭인지 확인
    public boolean isBlackJack() {
        if(getCardsSum() == 21){
            return true;
        }
        return false;
    }

    public void addCard() {
        Card card = CardDummy.drawCard();
        cards.add(card);
    }

    //Test를 위한 오버로드 메서드
    public void addCard(Card card) {
        cards.add(card);
    }

    public boolean isBust() {
        int cardsSum = getCardsSum();
        if (cardsSum > 21) {
            return true;
        }
        return false;
    }

    public int countAce() {
        int size = cards.stream()
            .filter(card -> card.getCardValue() == 11)
            .collect(Collectors.toList())
            .size();
        return size;
    }

    public void isFinished() {
        this.isFinished = true;
    }

    public int getSize() {
        return cards.size();
    }
}
