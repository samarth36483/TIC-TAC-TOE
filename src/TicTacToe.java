import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import controller.GameController;
import models.Bot;
import models.DifficultyLevel;
import models.Game;
import models.GameStatus;
import models.Move;
import models.Player;
import models.PlayerType;
import models.Symbol;
import strategy.botPlayingStrategy.BotPlayingStrategyFactory;

public class TicTacToe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		GameController gameController = new GameController();
		
		System.out.println("Please enter the dimension of the game");
		int dimension = scn.nextInt();
		
		System.out.println("Will there be any bot in the game ? Y/N");
		String isBotPresent = scn.next();
		
		List<Player> players = new ArrayList<>();
		int iteratorNumber = dimension-1;
		
		if(isBotPresent.equals("Y")) {
			iteratorNumber = dimension-2;
		}
		
		for(int i=0;i<iteratorNumber;i++){
            //TODO : validate if no one passes a duplicate symbol
            System.out.println("What is the name of the player number : " + (i+1));
            String playerName = scn.next();

            System.out.println("What is the character symbol of the player number : " + (i+1));
            String characterSymbol = scn.next();

            players.add(new Player(playerName, PlayerType.Human, new Symbol(characterSymbol.charAt(0)) ));
        }
		
		if(isBotPresent.equals("Y")) {
			System.out.println("Enter the name of Bot");
			String botName = scn.next();
			
			System.out.println("What is the character symbol of Bot");
			String botSymbol = scn.next();
			
			DifficultyLevel difficultyLevel = DifficultyLevel.Easy;
			
			Bot bot = new Bot(botName, new Symbol(botSymbol.charAt(0)), difficultyLevel, 
					BotPlayingStrategyFactory.getBotPlayingStrategyForDifficultyLevel(difficultyLevel.Easy));
			
			
			players.add(bot);
		}
		
		Collections.shuffle(players);
		
		Game game = gameController.createGame(dimension, players);
		int playerIndex = 0;
		
		while(game.getGameStatus().equals(GameStatus.InProgress)) {
			System.out.println("Current board status");
			gameController.displayBoard(game);
			playerIndex++;
			playerIndex = playerIndex % players.size();
			Move movePlayed = gameController.executeMove(game, game.getPlayers().get(playerIndex));
			Player winner = gameController.checkWinner(game, movePlayed);
			if(winner != null){
                gameController.displayBoard(game);
                System.out.println("Winner is : " + winner.getName());
                break;
            }
		}

	}

}
