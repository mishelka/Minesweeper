package minesweeper.consoleui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.WrongMethodTypeException;
import java.util.Formatter;

import minesweeper.core.Field;
import minesweeper.core.Tile;

/**
 * Console user interface.
 */
public class ConsoleUI implements UserInterface {
    /**
     * Playing field.
     */
    private Field field;

    private String format = "%2s";

    /**
     * Input reader.
     */
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Reads line of text from the reader.
     *
     * @return line as a string
     */
    private String readLine() {
        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Starts the game.
     *
     * @param field field of mines and clues
     */
    @Override
    public void newGameStarted(Field field) {
        this.field = field;

        this.format = "%"
                + (1 + String.valueOf(field.getColumnCount()).length())
                + "s";
        do {
            update();
            processInput();
        } while (true);
    }

    /**
     * Updates user interface - prints the field.
     */
    @Override
    public void update() {
        System.out.println("Metoda update():");

        System.out.printf(format, "");
        for (int c = 0; c < field.getColumnCount(); c++) {
            System.out.printf(format, c);
        }
        System.out.println();

        //vypis riadky so zvislo osou na zaciatku
        for (int r = 0; r < field.getRowCount(); r++) {
            System.out.printf(format, (char)(r + 65));
            for (int c = 0; c < field.getColumnCount(); c++) {
                System.out.printf(format, field.getTile(r, c));
            }
            System.out.println();
        }
    }

    /**
     * Processes user input.
     * Reads line from console and does the action on a playing field according to input string.
     */
    private void processInput() {
        String line = readLine().trim().toUpperCase();
    }

    private void handleInput(String input) throws WrongFormatException {

    }
}
