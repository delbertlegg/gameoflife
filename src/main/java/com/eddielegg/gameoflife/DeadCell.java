package com.eddielegg.gameoflife;

/**
 * Created by elegg on 3/29/17.
 */
public class DeadCell extends GameCell {
    public DeadCell(GameGrid grid) {
        super(grid);
    }

    public boolean changingStatus() {
        return grid.aliveNeighbors(this) == 3;
    }
}
