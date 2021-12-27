package practice.blackjack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import practice.blackjack.domain.BlackJackGame;
import practice.blackjack.domain.Player;
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
}
