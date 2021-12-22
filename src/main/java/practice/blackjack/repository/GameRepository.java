package practice.blackjack.repository;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import practice.blackjack.domain.Player;

@Repository
public class GameRepository {
	List<Player> players = new ArrayList<>();

	public void addPlayers(Player player) {
		players.add(player);
	}
}
