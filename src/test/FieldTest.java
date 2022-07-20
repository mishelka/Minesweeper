package test;

import minesweeper.core.Field;
import minesweeper.core.Mine;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FieldTest {

    private Random randomGenerator = new Random();
    private Field field;
    private int rowCount;
    private int columnCount;
    private int minesCount;

    public FieldTest() {
    }

    @BeforeEach
    public void initTests() {
        rowCount = randomGenerator.nextInt(10) + 5;
        columnCount = rowCount;
        minesCount = Math.max(1, randomGenerator.nextInt(rowCount * columnCount));
        field = new Field(rowCount, columnCount, minesCount);
    }

    @Test
    public void checkFieldInitialization() {

    }

    @Test
    public void checkMinesCount() {
        int minesCounter = 0;
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                if (field.getTile(row, column) instanceof Mine) {
                    minesCounter++;
                }
            }
        }
        assertEquals(minesCount, minesCounter, "Field was initialized incorrectly - " +
                "a different amount of mines was counted in the field than amount given in the constructor.");
    }

    @Test
    public void fieldWithTooManyMines() {
        Field fieldWithTooManyMines = null;
        int higherMineCount = rowCount * columnCount + randomGenerator.nextInt(10) + 1;
        try {
            fieldWithTooManyMines = new Field(rowCount, columnCount, higherMineCount);
        } catch (Exception e) {
            // field with more mines than tiles should not be created - it may fail on exception
        }
        assertTrue((fieldWithTooManyMines == null)
                || (fieldWithTooManyMines.getMineCount()
                <= (rowCount * columnCount)));
    }

    // ... dalsie testy
}