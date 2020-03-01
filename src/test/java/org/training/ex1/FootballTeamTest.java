package org.training.ex1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import static org.fest.assertions.Assertions.assertThat;

/**
 * The {@code FootballTeamTest} class should provide the unit testing for its SUT {@link FootballTeam}.
 * <p>
 * 1. The {@link FootballTeam} class has one attribute {@code gamesWon}. Verify the {@code setGamesWon} method
 * with different inputs. It's a good idea to include one happy path test case, a test for edge cases and test for
 * failing scenarios.
 * <p>
 * 2. The {@link FootballTeam} class implements the {@link Comparable} interface, so its test class should provide unit
 * testing for the {@code compareTo} method.
 *
 * @author Manuel Castellin
 * @since 2020-03-01
 */
@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {

    private static final int VALID_GAMES_WON = 10;
    private static final int INVALID_GAMES_WON = -1;

    public static Collection gamesWonTestData() {
        return Arrays.asList(new Object[][]{
                {0, 0, '='}, //testing edge cases with smallest increment
                {0, 1, '<'},
                {1, 0, '>'},
                {50, 99, '<'}, //trying cases with big numbers
                {99, 50, '>'},
                {99, 99, '='}
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInstanceWithInvalidGamesWon() {

        new FootballTeam(INVALID_GAMES_WON);

    }

    @Test
    public void createValidFootballTeamInstance() {

        FootballTeam team = new FootballTeam(VALID_GAMES_WON);

        assertThat(team.getGamesWon()).isEqualTo(VALID_GAMES_WON);

    }

    @Parameters(method = "gamesWonTestData")
    @Test
    public void compareTest(int team1GamesWon, int team2GamesWon, char expectedResult) {
        FootballTeam team1 = createFootballTeam(team1GamesWon);
        FootballTeam team2 = createFootballTeam(team2GamesWon);

        int comparisonResult = team1.compareTo(team2);

        assertResultWithExpectedValue(comparisonResult, expectedResult);
    }

    @Test
    public void compareWithNullParameter() {
        FootballTeam team = createFootballTeam(VALID_GAMES_WON);
        FootballTeam nullTeam = null;

        int comparisonResult = team.compareTo(nullTeam);

        assertThat(comparisonResult).isGreaterThan(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setInvalidGamesForFootballTeam() {

        createFootballTeam(INVALID_GAMES_WON);

    }

    private static FootballTeam createFootballTeam(int gamesWon) {
        FootballTeam team = new FootballTeam();
        team.setGamesWon(gamesWon);
        return team;
    }

    private static void assertResultWithExpectedValue(int result, char operator) {
        switch (operator) {
            case '>':
                assertThat(result).isGreaterThan(0);
                break;
            case '<':
                assertThat(result).isLessThan(0);
                break;
            case '=':
            default:
                assertThat(result).isEqualTo(0);
        }
    }
}