package practice.blackjack.domain.game;

public enum GameResult {
	BlackJack("블랙잭"),
	Win("승리"),
	Lose("패배"),
	Draw("비김");

	private String resultKorean;

	GameResult(String resultKorean) {
		this.resultKorean = resultKorean;
	}

	public String getResultKorean() {
		return resultKorean;
	}
}
