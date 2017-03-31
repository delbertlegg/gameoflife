package com.eddielegg.gameoflife;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class LiveCellTests {
    static GameCell cell;
    static GameGrid grid;

    @BeforeClass
    public static void setUpClass() {
        grid = Mockito.mock(GameGrid.class);
        cell = new LiveCell(grid);
    }

    @Test
    public void cellIsMarkedForDeathWithLessThan2LiveNeighbors() {
        when(grid.aliveNeighbors(cell)).thenReturn(1);
        assertTrue(cell.changingStatus());
    }

    @Test
    public void cellIsMarkedForDeathWithMoreThan3LiveNeighbors() {
        when(grid.aliveNeighbors(cell)).thenReturn(4);
        assertTrue(cell.changingStatus());
    }

    @Test
    public void cellIsNotMarkedForDeathWith3LiveNeighbors() {
        when(grid.aliveNeighbors(cell)).thenReturn(3);
        assertFalse(cell.changingStatus());
    }


}
