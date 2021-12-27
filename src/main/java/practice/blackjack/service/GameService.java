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

	public boolean allGameFinished() {
		for (BlackJackGame game : gameRepository.findAllGames()) {
			if (!game.isFinished()){
				return false;
			}
		}
		return true;
	}

}
