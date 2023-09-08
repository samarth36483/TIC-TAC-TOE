package strategy.botPlayingStrategy;

import models.Board;
import models.Cell;
import models.CellState;
import models.Move;
import models.Player;

public class RandomBotPlayingStrategy implements BotPlayingStrategy {

	@Override
	public Move makeMove(Player player, Board board) {
		for(int i=0; i<board.getDimension(); i++) {
			for(int j=0; j<board.getDimension(); j++) {
				if(board.getBoard().get(i).get(j).getCellState().equals(CellState.Empty)) {
					board.getBoard().get(i).get(j).setPlayer(player);
	                  board.getBoard().get(i).get(j).setCellState(CellState.Filled);
	                  return new Move(new Cell(i,j), player );
				}
			}
		}
		return null;
	}

}
