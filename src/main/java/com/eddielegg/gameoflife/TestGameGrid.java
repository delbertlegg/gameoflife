package com.eddielegg.gameoflife;

/**
 * Test fixture with known live and dead cells. All cells in row 4
 * are live, all others are dead.
 */
public class TestGameGrid extends GameGrid {
    public TestGameGrid() {
        cellGrid = new GameCell[8][6];
        populateGrid();
    }

    private void populateGrid() {
        for (int i = 0; i < cellGrid.length; i++) {
            for (int j = 0; j < cellGrid[i].length; j++) {
                if (i == 3) {
                    cellGrid[i][j] = new LiveCell(this);
                }
                else {
                    cellGrid[i][j] = new DeadCell(this);
                }

                cellGrid[i][j].setCoords(new Coordinates(i, j));
            }
        }
    }
}
