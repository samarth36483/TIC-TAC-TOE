package strategy.botPlayingStrategy;

import models.DifficultyLevel;

public class BotPlayingStrategyFactory {
	public static BotPlayingStrategy getBotPlayingStrategyForDifficultyLevel(DifficultyLevel level) {
		if(level.equals(DifficultyLevel.Easy))
			return new RandomBotPlayingStrategy();
		else if(level.equals(DifficultyLevel.Medium)) {
			return new RandomBotPlayingStrategy();
		}
		return new RandomBotPlayingStrategy();
    }

}
