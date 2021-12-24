package practice.blackjack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import practice.blackjack.domain.BlackJackMember;
import practice.blackjack.domain.Dealer;
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
		gameRepository.addPlayers(player);
	}
	
	public List<Player> getPlayerMembers() {
		List<Player> players = new ArrayList<>();
		for (BlackJackMember player : gameRepository.getPlayers()) {
			if (player instanceof Player) {
				players.add((Player)player);
			}
		}
		return players;
	}

	public Dealer getDealer() {
		int lastIndex = gameRepository.getPlayers().size() - 1;
		return (Dealer)gameRepository.getPlayers().get(lastIndex);
	}
}
