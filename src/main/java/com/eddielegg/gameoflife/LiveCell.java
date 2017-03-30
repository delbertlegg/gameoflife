package com.eddielegg.gameoflife;

/**
 * Created by elegg on 3/29/17.
 */
public class LiveCell extends GameCell{
    public LiveCell(GameGrid grid) {
        super(grid);
        status = CellStatus.LIVE;
    }

    public boolean changingStatus() {
        return grid.aliveNeighbors(this) < 2 ||
                grid.aliveNeighbors(this) > 3;
    }
}
