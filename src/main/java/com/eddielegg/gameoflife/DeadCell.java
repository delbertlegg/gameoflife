package com.eddielegg.gameoflife;

/**
 * Created by elegg on 3/29/17.
 */
public class DeadCell extends GameCell {
    public DeadCell(GameGrid grid) {
        super(grid);
        status = CellStatus.DEAD;
    }

    public boolean changingStatus() {
        return grid.aliveNeighbors(this) == MAX_LIVE_NEIGHBORS;
    }
}
