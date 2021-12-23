package practice.blackjack.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practice.blackjack.domain.BlackJackMember;
import practice.blackjack.domain.Dealer;
import practice.blackjack.domain.Player;
import practice.blackjack.domain.card.Cards;
import practice.blackjack.repository.GameRepository;

import java.util.List;

@Slf4j
@Service
public class GameService {
	GameRepository gameRepository;

	@Autowired
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	public void initializeGame() {
		for (BlackJackMember player : gameRepository.getPlayers()) {
			player.addCard();
			player.addCard();
			isBlackJack(player);
		}
		BlackJackMember dealer = new Dealer();
		dealer.addCard();
		gameRepository.addPlayers(dealer); // 그래서 어떻게 할지는 모름 일단 검증은 함
	}

	// hit
	public boolean hit(BlackJackMember member) {
		log.info("GameService: hit");
		member.addCard();
		return isBust(member);
	}

	// hit 했을 때 bust인지 확인
	private boolean isBust(BlackJackMember member) {
		log.info("GameService: isBust");
		log.info("| Sum={}",member.getCards().getCardsSum());
		if(member.getCards().getCardsSum()>21){
			return false;
		}
		return true;
	}

	// 블랙잭인지 확인
	private boolean isBlackJack(BlackJackMember member) {
		log.info("GameService: isBlackJack");
		log.info("| Sum={}",member.getCards().getCardsSum());
		if(member.getCards().getCardsSum()==21){
			return true;
		}
		return false;
	}

}
