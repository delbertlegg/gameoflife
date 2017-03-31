package com.eddielegg.gameoflife;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class AliveNeighborsTests {
    static GameGrid grid;
    static GameCell cell;

    @BeforeClass
    public static void setUpClass() {
        grid = new TestGameGrid();
        cell = Mockito.mock(GameCell.class);
    }

    @Test
    public void edgeCellReturnsTwoAliveNeighbors() {
        when(cell.getCoords()).thenReturn(new Coordinates(2, 0));
        assertEquals(2, grid.aliveNeighbors(cell));
    }

    @Test
    public void middleCellReturnsThreeLiveNeighbors() {
        when(cell.getCoords()).thenReturn(new Coordinates(2, 2));
        assertEquals(3, grid.aliveNeighbors(cell));
    }
}
