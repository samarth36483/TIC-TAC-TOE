package models;

import java.util.ArrayList;

public class Board {
	int dimension;
	ArrayList<ArrayList<Cell>> board;
	
	public Board(int dimension) {
		super();
		this.dimension = dimension;
		this.board = new ArrayList<ArrayList<Cell>>();
		
		for(int i=0; i<dimension; i++) {
			this.board.add(new ArrayList<Cell>());
			for(int j=0; j<dimension; j++) {
				this.board.get(i).add(new Cell(i, j));
			}
		}
	}
	
	public void printBoard() {
		for(int i=0; i<dimension; i++) {
			ArrayList<Cell> row = board.get(i);
			for(int j=0; j<dimension; j++) {
				row.get(j).display();
			}
			System.out.println();
		}
		
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public ArrayList<ArrayList<Cell>> getBoard() {
		return board;
	}

	public void setBoard(ArrayList<ArrayList<Cell>> board) {
		this.board = board;
	}
	

}
