package com.eddielegg.gameoflife;

abstract class GameCell {
    final int MIN_LIVE_NEIGHBORS = 2;
    final int MAX_LIVE_NEIGHBORS = 3;
    GameGrid grid;
    CellStatus status;
    Coordinates coords;

    public GameCell(GameGrid grid) {
        this.grid = grid;
    }

    public abstract boolean changingStatus();

    public CellStatus getStatus() {
        return status;
    }

    public Coordinates getCoords() {
        return coords;
    }


    public void setCoords(Coordinates coords) {
        this.coords = coords;
    }
}
