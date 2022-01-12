package practice.blackjack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import practice.blackjack.domain.Player;
import practice.blackjack.domain.game.BlackJackGame;
import practice.blackjack.repository.GameRepository;

@Slf4j
@Service
public class MemberService {
	GameRepository gameRepository;

	@Autowired
	public MemberService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	public void savePlayer(Player player) {
		log.info("MemberService: savePlayer");
		gameRepository.savePlayer(player);
	}
	
	public BlackJackGame getDealer() {
		return gameRepository.getDealerGame();
	}

	public List<BlackJackGame> getPlayerGames() {
		return gameRepository.findAllGames();
	}
	public Player getPlayer() {
		return gameRepository.getPlayer();
	}

	public void clearData() {
		gameRepository.clearData();
	}

	// if 딜러가 버스트인 경우, 살아남은 모든 게임은 이김
	// else 비교 수행
	public void ExecuteGameResult() {
		BlackJackGame dealerGame = gameRepository.getDealerGame();
		List<BlackJackGame> allGames = gameRepository.findAllGames();

		if (dealerGame.isBust()) {
			allGamesWinner(allGames);
			return;
		}

		int dealerSum = dealerGame.getCardsSum();
		for (BlackJackGame gameEach : allGames) {
			gameEach.setGameResultByDealer(dealerSum);
		}
	}

	private void allGamesWinner(List<BlackJackGame> games) {
		for (BlackJackGame game : games) {
			if (!game.isBust()) {
				game.winGame();
			}
		}
	}
}
