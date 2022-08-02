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


    private static Minesweeper instance;

    private Settings setting;

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
        setting = Settings.load();

        bestTimes.addPlayerTime("Janko", 9);
        bestTimes.addPlayerTime("Janko", 7);
        bestTimes.addPlayerTime("Janko", 3);
        bestTimes.addPlayerTime("Janko", 8);

        Field field = new Field(
                setting.getRowCount(),
                setting.getColumnCount(),
                setting.getMineCount()
        );

        userInterface = new ConsoleUI();
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



    public void setSetting(Settings setting) {
        this.setting = setting;
        this.setting.save();
    }

    public Settings getSetting() {
        return this.setting;
    }
}
