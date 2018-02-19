package org.training.ex3;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RegexNumberParserTest {

    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"abc 12", Collections.emptyList()},
                {"Cdefg 345 12bb23", Arrays.asList(345)},
                {"Cdefg 345 12bbb33 678tt", Arrays.asList(345, 678)}
        });
    }

    @Parameters(method = "testData")
    @Test
    public void shouldParseThreeOrMoreDigitsNumbersFromString(String stringToParse, Collection<Integer> resultCollection) {

        RegexNumberParser parser = new RegexNumberParser();

        Collection<Integer> parsedNumbers = parser.parseString(stringToParse);

        assertThat(parsedNumbers).containsOnly(resultCollection.toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentWithNullParameter() {
        RegexNumberParser parser = new RegexNumberParser();

        parser.parseString(null);
    }
}