package practice.blackjack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import practice.blackjack.service.GameService;
import practice.blackjack.service.MemberService;

@Controller
public class BlackJackController {
	GameService gameService;
	MemberService memberService;

	@Autowired
	public BlackJackController(GameService gameService, MemberService memberService) {
		this.gameService = gameService;
		this.memberService = memberService;
	}

	// 내가왔다
	// 나도 왔음
}
