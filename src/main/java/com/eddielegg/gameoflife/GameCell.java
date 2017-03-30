package com.eddielegg.gameoflife;

/**
 * Created by elegg on 3/29/17.
 */
public class GameCell {
    private GameGrid grid;
    private CellStatus status;

    public GameCell(GameGrid grid) {
        this.grid = grid;
    }

    public boolean markedForDeath() {
        return grid.aliveNeighbors(this) < 2 || grid.aliveNeighbors(this) > 3;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }

    public boolean markedForLife() {
        return grid.aliveNeighbors(this) == 3;
    }
}
