package practice.blackjack.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@PostMapping("/user")
	public String addUser() {
		log.info("Controller: userForm-post");
		// 로직 구현 필요
		return "redirect:/blackjack/play";
	}

	// 게임진행
	@GetMapping("/play")
	public String playGame() {
		log.info("Controller: playGame");
		// 로직
		return "/blackjack/play";
	}

	// 결과창
	@GetMapping("/result")
	public String resultPage() {
		log.info("Controller: resultPage");
		return "/blackjack/result";
	}

	// 률 설명
	@GetMapping("/rule")
	public String rulePage() {
		log.info("Controller: rulePage");
		return "/blackjack/rule";
	}

}
