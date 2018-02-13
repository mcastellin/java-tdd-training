package org.training.ex1;

public class FootballTeam implements Comparable<FootballTeam> {

    private int gamesWon;

    public int compareTo(FootballTeam o) {

        if (o.gamesWon < 0) {
            throw new IllegalArgumentException("cannot be less thann zero");
        }

        return gamesWon - o.gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }
}
