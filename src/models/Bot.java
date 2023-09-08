package models;

import strategy.botPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player {

	private DifficultyLevel difficultyLevel;
	private BotPlayingStrategy botPlayingStrategy;
	
	
	public Bot(String name, Symbol symbol, DifficultyLevel difficultyLevel,
			BotPlayingStrategy botPlayingStrategy) {
		super(name, PlayerType.Bot, symbol);
		this.difficultyLevel = difficultyLevel;
		this.botPlayingStrategy = botPlayingStrategy;
	}
	
	public Move makeMove(Board board) {
		Move move  = botPlayingStrategy.makeMove(this, board);
		// set player
		move.setPlayer(this);
		return move;
	}

	public DifficultyLevel getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public BotPlayingStrategy getBotPlayingStrategy() {
		return botPlayingStrategy;
	}

	public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
		this.botPlayingStrategy = botPlayingStrategy;
	}
	
	
	
}
