package com.eddielegg.gameoflife;

public class GameOfLifeClient {
    public static void main(String[] args) {
        GameGrid grid = new GameGrid();
        grid.printGrid();
        grid.generateNewGrid();
        grid.printGrid();
    }

}
