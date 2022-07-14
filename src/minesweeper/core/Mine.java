package minesweeper.core;

/**
 * Mine tile.
 */
public class Mine extends Tile {

    @Override
    public String toString() {
        if(this.getState() == Tile.State.OPEN) {
            return "*";
        }
        return super.toString();
    }
}
