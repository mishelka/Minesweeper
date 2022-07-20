package minesweeper;

import minesweeper.consoleui.ConsoleUI;
import minesweeper.consoleui.SwingUI;
import minesweeper.consoleui.UserInterface;
import minesweeper.core.BestTimes;
import minesweeper.core.Field;

/**
 * Main application class.
 */
public class Minesweeper {
    /** User interface. */
    private UserInterface userInterface;

    private BestTimes bestTimes = new BestTimes();

    private long startMillis = System.currentTimeMillis();
    private static Minesweeper instance;

    //vracia prave jednu instanciu singletona
    public static Minesweeper getInstance() {
        if(instance == null) {
            new Minesweeper();
        }
        return instance;
    }
 
    /**
     * Constructor.
     */
    //singleton - konstruktor musi byt private
    private Minesweeper() {
        instance = this; //singleton
        bestTimes.addPlayerTime("Janko", 9);
        bestTimes.addPlayerTime("Janko", 7);
        bestTimes.addPlayerTime("Janko", 3);
        bestTimes.addPlayerTime("Janko", 8);

        userInterface = new ConsoleUI();
        Field field = new Field(9, 9, 10);
        userInterface.newGameStarted(field);
    }

    /**
     * Main method.
     * @param args arguments
     */
    public static void main(String[] args) {
        Minesweeper.getInstance();
    }

    public BestTimes getBestTimes() {
        return bestTimes;
    }

    public int getPlayingSeconds() {
        return (int) ((System.currentTimeMillis() - startMillis)/1000);
    }
}
