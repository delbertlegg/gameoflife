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
public class DeadCellTests {
    static GameCell cell;
    static GameGrid grid;

    @BeforeClass
    public static void setUpClass() {
        grid = Mockito.mock(GameGrid.class);
        cell = new DeadCell(grid);
        cell.setStatus(CellStatus.DEAD);
    }

    @Test
    public void deadCellIsMarkedForLifeWith3LiveNeighbors() {
        when(grid.aliveNeighbors(cell)).thenReturn(3);
        assertTrue(cell.changingStatus());
    }

    @Test
    public void deadCellIsNotMarkedForLifeWith2LiveNeighbors() {
        when(grid.aliveNeighbors(cell)).thenReturn(2);
        assertFalse(cell.changingStatus());
    }
}
