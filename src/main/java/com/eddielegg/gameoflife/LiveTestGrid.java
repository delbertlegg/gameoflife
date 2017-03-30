package com.eddielegg.gameoflife;

public class LiveTestGrid extends GameGrid {
    public LiveTestGrid() {
        cellGrid = new GameCell[8][6];
        populateGrid();
    }

    private void populateGrid() {
        for (int i = 0; i < cellGrid.length; i++) {
            for (int j = 0; j < cellGrid[i].length; j++) {
                cellGrid[i][j] = new LiveCell(this);
                cellGrid[i][j].setCoords(new Coordinates(i, j));
            }
         }
    }
}

