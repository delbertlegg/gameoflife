package com.eddielegg.gameoflife;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class GameGridTests {
    static GameGrid grid;
    static GameCell cell;

    @BeforeClass
    public static void setUpClass() {
        grid = new LiveTestGrid();
        cell = Mockito.mock(GameCell.class);
    }

    @Test
    public void testCornerCellReturnsThreeNeighbors() {
        when(cell.getCoords()).thenReturn(new Coordinates(0, 0));
        assertEquals(3, grid.aliveNeighbors(cell));
    }

    @Test
    public void testEdgeCellReturnsFiveNeighbors() {
        when(cell.getCoords()).thenReturn(new Coordinates(0, 1));
        assertEquals(5, grid.aliveNeighbors(cell));
    }

    @Test
    public void testMiddleCellReturnsEightNeighbors() {
        when(cell.getCoords()).thenReturn(new Coordinates(1, 1));
        assertEquals(8, grid.aliveNeighbors(cell));
    }


}
