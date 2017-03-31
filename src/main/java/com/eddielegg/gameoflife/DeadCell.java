package com.eddielegg.gameoflife;

public class DeadCell extends GameCell {
    public DeadCell(GameGrid grid) {
        super(grid);
        status = CellStatus.DEAD;
    }

    public boolean changingStatus() {
        return grid.aliveNeighbors(this) == MAX_LIVE_NEIGHBORS;
    }
}
