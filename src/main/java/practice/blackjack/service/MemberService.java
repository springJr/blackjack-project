package practice.blackjack.service;

import java.lang.reflect.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practice.blackjack.domain.Player;
import practice.blackjack.repository.GameRepository;

@Service
public class MemberService {
	GameRepository gameRepository;

	@Autowired
	public MemberService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	public void savePlayer(Player player) {
		gameRepository.addPlayers(player);
	}
}
