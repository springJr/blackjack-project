package practice.blackjack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practice.blackjack.domain.BlackJackMember;
import practice.blackjack.domain.Dealer;
import practice.blackjack.domain.Player;
import practice.blackjack.repository.GameRepository;

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
		}
		BlackJackMember dealer = new Dealer();
		dealer.addCard();
		gameRepository.addPlayers(dealer);
	}
}
