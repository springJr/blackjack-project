package practice.blackjack.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import practice.blackjack.domain.game.BlackJackGame;
import practice.blackjack.domain.Player;

@Getter
@Repository
public class GameRepository {
	private Player player;
	private BlackJackGame dealerGame;
	private Map<Long, BlackJackGame> gameRepository = new HashMap<>();

	public void savePlayer(Player player) {
		this.player = player;
		this.dealerGame = new BlackJackGame();
		dealerGame.addCard();
		addGamesByAmount(player.getGameAmount());
	}

	private void addGamesByAmount(int amount) {
		Long id = 1L;
		for (int i = 0; i < amount; i++) {
			BlackJackGame blackJackGame = new BlackJackGame();
			blackJackGame.setGameId(id++);
			blackJackGame.addCard();
			blackJackGame.addCard();
			gameRepository.put(blackJackGame.getGameId(), blackJackGame);
		}
	}

	public BlackJackGame findById(Long gameId) {
		return gameRepository.get(gameId);
	}

	public List<BlackJackGame> findAllGames() {
		return new ArrayList<>(gameRepository.values());
	}

	public void clearData() {
		gameRepository.clear();
		this.dealerGame = new BlackJackGame();
	}
}
