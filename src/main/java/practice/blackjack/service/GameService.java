package practice.blackjack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import practice.blackjack.domain.BlackJackGame;
import practice.blackjack.repository.GameRepository;

@Slf4j
@Service
public class GameService {
	GameRepository gameRepository;

	@Autowired
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	public BlackJackGame findGameById(Long gameId) {
		return gameRepository.findById(gameId);
	}

	// // hit
	// public boolean hit(BlackJackMember member) {
	// 	log.info("GameService: hit");
	// 	member.addCard();
	// 	return isBust(member);
	// }
	//
	// // hit 했을 때 bust인지 확인
	// private boolean isBust(BlackJackMember member) {
	// 	log.info("GameService: isBust");
	// 	log.info("| Sum={}",member.getCards().getCardsSum());
	// 	if(member.getCards().getCardsSum()>21){
	// 		return false;
	// 	}
	// 	return true;
	// }
}
