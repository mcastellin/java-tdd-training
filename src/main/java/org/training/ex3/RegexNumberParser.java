package org.training.ex3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexNumberParser {
    public Collection<Integer> parseString(String stringToParse) {

        if (stringToParse == null) {
            throw new IllegalArgumentException("Null is not a valid input parameter");
        }

        List<Integer> groups = new ArrayList<Integer>();
        Pattern pattern = Pattern.compile("(\\d{3,})");
        Matcher matcher = pattern.matcher(stringToParse);
        while (matcher.find()) {
            groups.add(Integer.parseInt(matcher.group(1)));
        }

        return groups;
    }
}
