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
public class FootballTeamParametrizedExampleTest {

    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {1, 2},
                {2, 2},
                {3, 4}
        });
    }

    @Parameters(method = "testData")
    @Test
    public void test(int a, int b) {
        System.out.println(String.format("Inputs: a: %d, b: %d", a, b));

        assertThat(a).isNotEqualTo(b);
    }

}