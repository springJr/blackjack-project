package practice.blackjack.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import practice.blackjack.domain.BlackJackMember;
import practice.blackjack.domain.Player;

@Getter
@Repository
public class GameRepository {
	private List<BlackJackMember> players = new ArrayList<>();

	public void addPlayers(BlackJackMember player) {
		players.add(player);
	}
}
