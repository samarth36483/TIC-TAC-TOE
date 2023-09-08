package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import exception.DuplicateSymbolException;
import exception.InvalidBotCountException;
import exception.InvalidDimensionException;
import exception.InvalidPlayersException;
import strategy.WinningStrategy.WinningStrategy;

public class Game {
	private List<Player> players;
	private Board board;
	ArrayList<Move> moves;
	private Player winner;
	private GameStatus gameStatus;
	private List<WinningStrategy> winningStrategy;
	
	private Game(List<Player> players, Board board, List<WinningStrategy> winningStrategy) {
		this.players = players;
		this.board = board;
		this.winningStrategy = winningStrategy;
		this.moves = new ArrayList<Move>();
		this.gameStatus = GameStatus.InProgress;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public Board getBoard() {
		return board;
	}

	public ArrayList<Move> getMoves() {
		return moves;
	}

	public Player getWinner() {
		return winner;
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}

	public List<WinningStrategy> getWinningStrategy() {
		return winningStrategy;
	}
	
	public static Builder builder(){
        return new Builder();
    }
	
	public static class Builder{
		private List<Player> players;
		private List<WinningStrategy> winningStrategies;
		private int dimension;
		
		private Builder() {
			this.players = new ArrayList<Player>();
			this.winningStrategies = new ArrayList<WinningStrategy>();
			this.dimension = 0;
		}
		
		public Builder setPlayers(List<Player> players) {
			this.players = players;
			return this;
		}

		public Builder setWinningStrategies(List<WinningStrategy> list) {
			this.winningStrategies = list;
			return this;
		}

		public Builder setDimension(int dimension) {
			this.dimension = dimension;
			return this;
		}

		public void addPlayer(Player player) {
			players.add(player);
		}
		
		public void addWinningStrategies(WinningStrategy winningStrategy) {
			winningStrategies.add(winningStrategy);
		}
		
		private void validateBotCount() {
			int botCount = 0;
			for(Player player : players) {
				if(player.getPlayerType().equals(PlayerType.Bot))
					botCount++;
			}
			if(botCount > 1)
				throw new InvalidBotCountException("Bot count exceeded 1");
		}
		
		private void validateDimension() {
			if(dimension<3 || dimension > 10) {
				throw new InvalidDimensionException("Dimension should be between 3 and 10");
			}
		}
		
		private void validateNumberOfPlayers() {
			if(players.size() != dimension-1)
				throw new InvalidPlayersException("Players should be 1 less than dimension");
		}
		
		private void validateUniqueSymbolForAllPlayers(){
            HashSet<Character> set = new HashSet<>();
            for(Player player : players){
                set.add(player.getSymbol().getSymbol());
            }

            if(set.size() != players.size()){
                throw new DuplicateSymbolException("Every player should have unique symbol");
            }
        }
		
		private void validate() {
			validateBotCount();
			validateDimension();
			validateNumberOfPlayers();
			validateUniqueSymbolForAllPlayers();
		}
		
		public Game build() {
			validate();
			return new Game(players, new Board(dimension), winningStrategies);
		}
		
	}
}
