package practice.blackjack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import practice.blackjack.domain.BlackJackGame;
import practice.blackjack.repository.GameRepository;

@Slf4j
@Service
public class GameService {
	GameRepository gameRepository;

	@Autowired
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	public BlackJackGame findGameById(Long gameId) {
		return gameRepository.findById(gameId);
	}

	// ------------------ game (player) ------------------
	// hit
	public void hitGameById(Long gameId) {
		BlackJackGame blackJackGame = findGameById(gameId);
		blackJackGame.addCard();
	}

	// stand
	public void standGameById(Long gameId) {
		BlackJackGame blackJackGame = findGameById(gameId);
		blackJackGame.checkIsFinished();
	}

	// isBust
	public boolean isBustGameById(Long gameId) {
		BlackJackGame blackJackGame = findGameById(gameId);
		return blackJackGame.isBust();
	}

	// ------------------ 딜러턴 시작 & 딜러턴 끝 ------------------
	// 게임이 끝났는지 (플레이어의 턴이 다 끝났는지)
	public boolean allGameFinished() {
		for (BlackJackGame game : gameRepository.findAllGames()) {
			if (!game.isFinished()){
				return false;
			}
		}
		return true;
	}

	public boolean dealerTurnFinished() {
		BlackJackGame dealer = gameRepository.getDealerGame();
		return shouldHit(dealer);
	}

	// ------------------ dealer ------------------
	public void hitDealer() {
		BlackJackGame dealer = gameRepository.getDealerGame();
		if (shouldHit(dealer)) {
			dealer.addCard();
		}
	}

	private boolean shouldHit(BlackJackGame dealer) {
		final int DEALER_BUST_FLAG=17;
		if (dealer.getCardsSum()<DEALER_BUST_FLAG) {
			return true;
		}
		return false;
	}

}
