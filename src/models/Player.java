package models;

import java.util.Scanner;

public class Player {
	private String name;
	private PlayerType playerType;
	private Symbol symbol;
	private Scanner scn;
	
	
	public Player(String name, PlayerType playerType, Symbol symbol) {
		super();
		this.name = name;
		this.playerType = playerType;
		this.symbol = symbol;
		this.scn = new Scanner(System.in);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public PlayerType getPlayerType() {
		return playerType;
	}


	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
	}


	public Symbol getSymbol() {
		return symbol;
	}


	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}


	public Scanner getScanner() {
		return scn;
	}


	public void setScanner(Scanner scn) {
		this.scn = scn;
	}
	
	public Move makeMove(Board board) {
		System.out.println("Enter the row to make move");
		int row = scn.nextInt();
		System.out.println("Enter the column to make move");
		int col = scn.nextInt();
		// validate cell state -> should be empty
		// make cell state filled
		// store player in the cell
		board.getBoard().get(row).get(col).setPlayer(this);
        board.getBoard().get(row).get(col).setCellState(CellState.Filled);
        return new Move(new Cell(row,col,this), this);
	}

}
