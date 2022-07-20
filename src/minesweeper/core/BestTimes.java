package minesweeper.core;

import java.util.*;

/**
 * Player times.
 */
public class BestTimes implements Iterable<BestTimes.PlayerTime> {
    /** List of best player times. */
    private List<PlayerTime> playerTimes = new ArrayList<PlayerTime>();

    /**
     * Returns an iterator over a set of  best times.
     * @return an iterator
     */
    public Iterator<PlayerTime> iterator() {
        return playerTimes.iterator();
    }

    /**
     * Adds player time to best times.
     * @param name name ot the player
     * @param time player time in seconds
     */
    public void addPlayerTime(String name, int time) {
        playerTimes.add(new PlayerTime(name,time));
        Collections.sort(playerTimes);
    }

    /**
     * Returns a string representation of the object.
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        Formatter f = new Formatter();
        playerTimes
                .stream()
                .forEach(pt -> f.format(pt.getName()+" "+pt.getTime()+"%n"));
        return f.toString();
    }

    /**
     * Player time.
     */
    public static class PlayerTime implements Comparable<PlayerTime> {
        /** Player name. */
        private final String name;

        /** Playing time in seconds. */
        private final int time;

        /**
         * Constructor.
         * @param name player name
         * @param time playing game time in seconds
         */
        public PlayerTime(String name, int time) {
            this.name = name;
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public int getTime() {
            return time;
        }

        @Override
        public int compareTo(PlayerTime o) {
            return Integer.compare(this.getTime(), o.getTime());
//            return this.getTime() - o.getTime();
        }
    }
}