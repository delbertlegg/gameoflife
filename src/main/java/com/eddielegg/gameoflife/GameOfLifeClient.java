package com.eddielegg.gameoflife;

/**
 * Created by elegg on 3/31/17.
 */
public class GameOfLifeClient {
    public static void main(String[] args) {
        GameGrid grid = new GameGrid();
        grid.printGrid();
        grid.generateNewGrid();
        grid.printGrid();
    }

}
