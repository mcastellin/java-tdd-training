package org.training.ex1;

/**
 * The {@code FootballTeam} class is an oversimplified class that represents a football team.
 * The class contains just one attribute to store the number of games won by the team.
 *
 * @author Manuel Castellin
 * @since 2020-03-01
 */
public class FootballTeam implements Comparable<FootballTeam> {

    private int gamesWon;

    /**
     * Creates a new instance of {@link FootballTeam} class
     */
    public FootballTeam() {
        super();
    }

    /**
     * Creates a new instance of {@link FootballTeam} class.
     *
     * @param gamesWon the number of games won by the team
     */
    public FootballTeam(int gamesWon) {
        setGamesWon(gamesWon);
    }

    /**
     * {@inheritDoc}
     */
    public int compareTo(FootballTeam o) {

        if (!(o instanceof FootballTeam)) {
            return 1;
        }

        if (o.gamesWon < 0 || this.gamesWon < 0) {
            throw new IllegalArgumentException("Games won for a FootballTeam object cannot be negative!");
        }

        return gamesWon - o.gamesWon;
    }

    /**
     * Sets the number of games won by the team
     *
     * @param gamesWon the number of games won
     */
    public void setGamesWon(int gamesWon) {
        if (gamesWon < 0) {
            throw new IllegalArgumentException("Games won for a FootballTeam object cannot be negative!");
        }
        this.gamesWon = gamesWon;
    }

    /**
     * Returns the number of games won
     *
     * @return the number of games won by the team
     */
    public int getGamesWon() {
        return this.gamesWon;
    }
}
