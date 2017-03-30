package com.eddielegg.gameoflife;

/**
 * Created by elegg on 3/29/17.
 */
public abstract class GameCell {
    GameGrid grid;
    CellStatus status;

    public GameCell(GameGrid grid) {
        this.grid = grid;
    }

    public abstract boolean changingStatus();


    public void setStatus(CellStatus status) {
        this.status = status;
    }
}
