package org.training.ex1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import static org.fest.assertions.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {

    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {4, 5, -1},
                {5, 5, 0},
        });
    }

    @Parameters(method = "testData")
    @Test
    public void compareTest(int a, int b, int testResult) {
        FootballTeam team = new FootballTeam();
        team.setGamesWon(a);

        FootballTeam team2 = new FootballTeam();
        team2.setGamesWon(b);

        int result = team.compareTo(team2);

//        assertTrue(result > 0);
        assertThat(result).isEqualTo(testResult);
    }
}