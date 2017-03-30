package com.eddielegg.gameoflife;

public class LiveCell extends GameCell {
    public LiveCell(GameGrid grid) {
        super(grid);
        status = CellStatus.LIVE;
    }

    public boolean changingStatus() {
        return grid.aliveNeighbors(this) < MIN_LIVE_NEIGHBORS ||
                grid.aliveNeighbors(this) > MAX_LIVE_NEIGHBORS;
    }
}
