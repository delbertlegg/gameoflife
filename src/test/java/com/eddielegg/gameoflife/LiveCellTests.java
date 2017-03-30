package com.eddielegg.gameoflife;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by elegg on 3/29/17.
 */
public class LiveCellTests {
    static GameCell cell;
    static GameGrid grid;

    @BeforeClass
    public static void setUpClass() {
        grid = Mockito.mock(GameGrid.class);
        cell = new LiveCell(grid);
        cell.setStatus(CellStatus.LIVE);
    }

    @Test
    public void cellIsMarkedForDeathWithLessThan2AliveNeighbors() {
        when(grid.aliveNeighbors(cell)).thenReturn(1);
        assertTrue(cell.changingStatus());
    }

    @Test
    public void cellIsMarkedForDeathWithMoreThan3AliveNeighbors() {
        when(grid.aliveNeighbors(cell)).thenReturn(4);
        assertTrue(cell.changingStatus());
    }

    @Test
    public void cellIsNotMarkedForDeathWith3Neighbors() {
        when(grid.aliveNeighbors(cell)).thenReturn(3);
        assertFalse(cell.changingStatus());
    }


}
