package practice.blackjack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practice.blackjack.repository.GameRepository;

@Service
public class GameService {
	GameRepository gameRepository;

	@Autowired
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

}
