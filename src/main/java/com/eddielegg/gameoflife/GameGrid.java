package com.eddielegg.gameoflife;

import com.sun.xml.internal.fastinfoset.algorithm.DoubleEncodingAlgorithm;

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
        int endPosX =   (thisX + 1 >= cellGrid.length) ? thisX : thisX + 1;
        int endPosY =   (thisY + 1 >= cellGrid[0].length) ? thisY : thisY + 1;

        int aliveNeighbors = 0;
        for (int rowNum=startPosX; rowNum<=endPosX; rowNum++) {
            for (int colNum=startPosY; colNum<=endPosY; colNum++) {
                if (rowNum != thisX || colNum != thisY) {
                   if (cellIsAlive(cellGrid[rowNum][colNum])) {
                       aliveNeighbors++;
                   }
                }
            }
        }
        return aliveNeighbors;
    }

    private boolean cellIsAlive(GameCell gameCell) {
        return gameCell.getStatus().equals(CellStatus
                .LIVE);
    }

    public GameCell changeStatus(GameCell cell) {
        if (cell.getStatus() == CellStatus.LIVE) {
            return new DeadCell(this);
        }
        return new LiveCell(this);
    }

    public void generateNewGrid() {
        GameCell[][] newGrid = new GameCell[cellGrid.length][cellGrid[0].length];
        for (int i = 0; i < cellGrid.length; i++) {
            for (int j = 0; j < cellGrid[i].length; j++) {
                if (cellGrid[i][j].changingStatus()) {
                    newGrid[i][j] = changeStatus(cellGrid[i][j]);
                }
                else {
                    newGrid[i][j] = cellGrid[i][j];
                }
            }
        }
        cellGrid = newGrid;
    }

    public void printGrid() {
        for (int i = 0; i < cellGrid.length; i++) {
            for (int j = 0; j < cellGrid[i].length; j++) {
                if (cellGrid[i][j].getStatus() == CellStatus.LIVE) {
                    System.out.print("O");
                }
                else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
