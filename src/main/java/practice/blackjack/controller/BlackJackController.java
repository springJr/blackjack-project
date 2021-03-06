package practice.blackjack.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import practice.blackjack.domain.game.BlackJackGame;
import practice.blackjack.domain.Player;
import practice.blackjack.domain.Sexs;
import practice.blackjack.service.GameService;
import practice.blackjack.service.MemberService;

@Slf4j
@Controller
@RequestMapping("/blackjack")
public class BlackJackController {
	GameService gameService;
	MemberService memberService;


	@Autowired
	public BlackJackController(GameService gameService, MemberService memberService) {
		this.gameService = gameService;
		this.memberService = memberService;
	}


	// 메인페이지
	@GetMapping("/main")
	public String mainPage() {
		log.info("mainPage");
		return "/blackjack/index";
	}

	// 유저 form
	@GetMapping("/user")
	public String userForm(Model model) {
		log.info("Controller: userForm-get");
		model.addAttribute("player",new Player());
		model.addAttribute("sexs", Sexs.values());
		return "/blackjack/form";
	}

	// 유저 추가
	@PostMapping("/user")
	public String addUser(@ModelAttribute Player player) {
		log.info("Controller: userForm-post");
		log.info("| userName={}",player.getUserName());
		log.info("| userSex={}",player.getUserSex());
		log.info("| gameAmount={}",player.getGameAmount());
		memberService.savePlayer(player);
		return "redirect:/blackjack/play";
	}
	// ------------------ 전체적인 게임 페이지 ------------------
	// 게임진행
	@GetMapping("/play")
	public String playGame(Model model) {
		log.info("Controller: playGame");
		// 로직
		model.addAttribute("dealerCards",memberService.getDealer().getCards());
		model.addAttribute("player",memberService.getPlayer());
		model.addAttribute("playerGames",memberService.getPlayerGames());
		model.addAttribute("dealerTurn", gameService.allGameFinished());
		return "/blackjack/play";
	}

	// ------------------ 1게임 관련 ------------------
	// 1게임 진행
	@GetMapping("/play/{gameId}")
	public String gameEach(@PathVariable Long gameId, Model model) {
		BlackJackGame blackJackGame = gameService.findGameById(gameId);
		blackJackGame.isBlackJack();
		model.addAttribute("blackJackGame", blackJackGame);
		model.addAttribute("blackJackGameCards", blackJackGame.getCards());
		model.addAttribute("isBust",gameService.isBustGameById(gameId));
		return "blackjack/gameEach";
	}

	// 1게임 진행 (hit)
	@GetMapping("/play/{gameId}/hit")
	public String gameEachHit(@PathVariable Long gameId) {
		log.info("Controller: hit!");
		gameService.hitGameById(gameId);
		return "redirect:/blackjack/play/{gameId}";
	}

	// 1게임 진행 (stand)
	@GetMapping("/play/{gameId}/stand")
	public String gameEachStand(@PathVariable Long gameId) {
		log.info("Controller: stand!");
		gameService.standGameById(gameId);
		return "redirect:/blackjack/play";
	}

	// ------------------ 딜러 턴 ------------------
	@GetMapping("/dealer/page")
	public String dealerTurn(Model model) {
		log.info("Controller: dealerTurn");
		model.addAttribute("dealerCards",memberService.getDealer().getCards());
		model.addAttribute("player",memberService.getPlayer());
		model.addAttribute("playerGames",memberService.getPlayerGames());
		model.addAttribute("dealerTurn", gameService.dealerTurnFinished());
		return "/blackjack/dealerTurn";
	}

	@GetMapping("/dealer/draw")
	public String dealerDraw() {
		log.info("Controller: dealerDraw");
		gameService.hitDealer();
		return "redirect:/blackjack/dealer/page";
	}

	// ------------------ 결과창 ------------------
	@GetMapping("/result")
	public String resultPage(Model model) {
		// 로직
		log.info("Controller: resultPage");
		memberService.ExecuteGameResult();

		model.addAttribute("dealerCards",memberService.getDealer().getCards());
		model.addAttribute("player",memberService.getPlayer());
		model.addAttribute("playerGames",memberService.getPlayerGames());
		model.addAttribute("dealerTurn", gameService.allGameFinished());

		return "/blackjack/result";
	}

	// 률 설명
	@GetMapping("/rule")
	public String rulePage() {
		log.info("Controller: rulePage");
		return "/blackjack/rule";
	}
	@GetMapping("/main/reset")
	public String resetData() {
		log.info("Controller: resetData");

		memberService.clearData();

		return "/blackjack/index";
	}

}
