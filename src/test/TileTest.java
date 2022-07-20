package test;

import minesweeper.core.Clue;
import minesweeper.core.Mine;

import minesweeper.core.Tile;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TileTest {
    @Test
    public void testTile() {
        Tile t = new Mine();
        assertInstanceOf(Mine.class, t, "Mina by mala byt typu Mine!");

        int expectedValue = 10;
        Clue c = new Clue(expectedValue);
        t = c;
        assertInstanceOf(Clue.class, t, "Clue by mala byt typu Clue!");
        assertEquals(expectedValue, c.getValue());
    }
}
