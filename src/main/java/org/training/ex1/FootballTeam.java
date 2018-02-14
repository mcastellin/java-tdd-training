package org.training.ex1;

public class FootballTeam implements Comparable<FootballTeam> {

    private int gamesWon;

    public FootballTeam() {
        super();
    }

    public FootballTeam(int gamesWon) {
        setGamesWon(gamesWon);
    }

    public int compareTo(FootballTeam o) {

        if (!(o instanceof FootballTeam)) {
            return 1;
        }

        if (o.gamesWon < 0 || this.gamesWon < 0) {
            throw new IllegalArgumentException("Games won for a FootballTeam object cannot be negative!");
        }

        return gamesWon - o.gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        if (gamesWon < 0) {
            throw new IllegalArgumentException("Games won for a FootballTeam object cannot be negative!");
        }
        this.gamesWon = gamesWon;
    }

    public int getGamesWon() {
        return this.gamesWon;
    }
}
