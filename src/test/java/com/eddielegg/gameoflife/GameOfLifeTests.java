package com.eddielegg.gameoflife;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by elegg on 3/29/17.
 */
public class GameOfLifeTests {
    static GameCell cell;

    @BeforeClass
    public static void setUpClass() {
        cell = new GameCell();
    }

    @Test
    public void cellIsMarkedForDeath() {
        assertTrue(cell.markedForDeath());
    }
}
