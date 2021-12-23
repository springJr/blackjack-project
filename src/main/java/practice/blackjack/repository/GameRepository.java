package practice.blackjack.repository;

import org.springframework.stereotype.Repository;
import practice.blackjack.domain.Player;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GameRepository {
	List<Player> players = new ArrayList<>();

	public void addPlayers(Player player) {
		players.add(player);
	}



}
