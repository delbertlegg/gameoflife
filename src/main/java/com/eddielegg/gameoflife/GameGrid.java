package com.eddielegg.gameoflife;

import java.util.Random;

class GameGrid {
    GameCell[][] cellGrid;
    public GameGrid() {
        cellGrid = new GameCell[8][6];
        populateGrid();
    }

    private void populateGrid() {
        for (int i = 0; i < cellGrid.length; i++) {
            for (int j = 0; j < cellGrid[i].length; j++) {
                int ran = new Random().nextInt(cellGrid.length * 2 + 1);
                if (ran > cellGrid.length * 2 * .75) {
                    cellGrid[i][j] = new LiveCell(this);
                }
                else {
                    cellGrid[i][j] = new DeadCell(this);
                }
                cellGrid[i][j].setCoords(new Coordinates(i, j));
            }
        }
    }


    public int aliveNeighbors(GameCell gameCell) {
        Coordinates coord = gameCell.getCoords();
        int thisX = coord.getX();
        int thisY = coord.getY();

        int startPosX = (thisX - 1 < 0) ? thisX : thisX-1;
        int startPosY = (thisY - 1 < 0) ? thisY : thisY - 1;
        int endPosX =   (thisX + 1 > cellGrid.length) ? thisX : thisX + 1;
        int endPosY =   (thisY + 1 > cellGrid[0].length) ? thisY : thisY + 1;

        int aliveNeighbors = 0;
        for (int rowNum=startPosX; rowNum<=endPosX; rowNum++) {
            for (int colNum=startPosY; colNum<=endPosY; colNum++) {
                if (rowNum != thisX || colNum != thisY) {
                   if (cellGrid[rowNum][colNum].getStatus().equals(CellStatus.LIVE)) {
                       aliveNeighbors++;
                   }
                }
            }
        }
        return aliveNeighbors;
    }

}
