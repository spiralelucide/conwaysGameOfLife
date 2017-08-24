package com.spiraledlogic.web.model;

public class ConwayGameOfLife{
	private final Boolean[][] initialState;
	private final int width;
	private final int height;

	public Boolean[][] getGameboard() {
		return initialState;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public ConwayGameOfLife(Boolean[][] initialState, int height, int width) {
		this.width = width;
		this.height = height;
		this.initialState = initialState;
	}
	public ConwayGameOfLife(int height, int width, double probability) {
		this.width = width;
		this.height = height;
		initialState = new Boolean[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(Math.random() <= probability) {
					initialState[i][j] = true;
				}else {
					initialState[i][j] = false;
				}
			}
		}
	}
	//Overloaded constructor to generate manipulatable copy
	public ConwayGameOfLife(ConwayGameOfLife board) {
		this.width = board.width;
		this.height = board.height;
		this.initialState = new Boolean[height][];
		for(int i = 0; i < height; i++) {
			initialState[i] = board.getGameboard()[i].clone();
		}
	}
	
	public Boolean[][] generateNextState(){
		ConwayGameOfLife nextBoard = new ConwayGameOfLife(this);
		Boolean[][] nextState = nextBoard.getGameboard();
		observeCell(nextState,0,0);
		return nextState;
	}
	
	//recursively gathers all cell information before applying it
	private void observeCell(Boolean[][] nextState,int rowIndex, int columnIndex){
		if(rowIndex == height) {
			return;
		}
		//game logic
		int neighborsAlive = observeNeighbors(nextState,rowIndex, columnIndex);
		if(columnIndex == width-1) {
			observeCell(nextState,rowIndex+1, 0);
		}else {
			observeCell(nextState,rowIndex, columnIndex+1);
		}
		//applies all state changes
		Boolean cellState = nextState[rowIndex][columnIndex];
		nextState[rowIndex][columnIndex] = cellState && neighborsAlive == 2 || neighborsAlive == 3;
		return;
	}
	
	
	private int observeNeighbors(Boolean[][] nextState, int x, int y) {
		int count = 0;
		//Checks to make sure test is in array bounds, then takes the state of the neighboring cell
		if(x-1 >= 0)
			if(nextState[x-1][y] == true) count++;
		if(x+1 < height)
			if(nextState[x+1][y] == true) count++;
		if(y-1 >= 0)
			if(nextState[x][y-1] == true) count++;
		if(y+1 < width)
			if(nextState[x][y+1] == true) count++;
		if(x-1 >= 0 && y-1 >= 0)
			if(nextState[x-1][y-1] == true) count++;
		if(x-1 >= 0 && y+1 < width)
			if(nextState[x-1][y+1] == true) count++;
		if(x+1 < height && y-1 >= 0)
			if(nextState[x+1][y-1] == true) count++;
		if(x+1 < height && y+1 < width)
			if(nextState[x+1][y+1] == true) count++;
		return count;
	}
	
	@Override
	//Used for testing
	public String toString() {
		String gameString = "";
		for(int i = 0; i < initialState.length; i++) {
			for(int j = 0; j < initialState[i].length; j++) {
					gameString = gameString + " " + initialState[i][j];
				}
			}
		return gameString;
	}
}
