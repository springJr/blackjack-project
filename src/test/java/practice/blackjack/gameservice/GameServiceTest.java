package practice.blackjack.gameservice;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import practice.blackjack.domain.Player;
import practice.blackjack.repository.GameRepository;
import practice.blackjack.service.GameService;

public class GameServiceTest {

	@Test
	void GameInitTest() {
		//given
		GameRepository gameRepository = new GameRepository();
		GameService gameService = new GameService(gameRepository);

		//when
		gameRepository.addPlayers(new Player());
		gameService.initializeGame();

		//then
		assertThat(gameRepository.getPlayers()
			.get(0).getCards()
			.getSize()).isEqualTo(2);
	}
}
