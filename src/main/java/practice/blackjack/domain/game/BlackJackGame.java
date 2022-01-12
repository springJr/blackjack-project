package practice.blackjack.domain.game;

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
    private GameResult gameResult;

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
        if (getCardsSum() == 21) {
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

    // !-- Bust의 유무만 판단하는 메서드 추출 필요
    public boolean isBust() {
        int cardsSum = getCardsSum();
        if (cardsSum > 21) {
            checkIsFinished();
            this.isFinished = true;
            this.gameResult = GameResult.Lose;
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

    public void checkIsFinished() {
        this.isFinished = true;
    }

    public int getSize() {
        return cards.size();
    }

    public void winGame() {
        this.gameResult = GameResult.Win;
    }

    public void setGameResultByDealer(int dealerSum) {
        int cardsSum = getCardsSum();
        if (dealerSum > cardsSum) {
            this.gameResult = GameResult.Lose;
        } else if (dealerSum == cardsSum) {
            this.gameResult = GameResult.Draw;
        } else if (dealerSum < cardsSum) {
            this.gameResult = GameResult.Win;
        }
    }
}
