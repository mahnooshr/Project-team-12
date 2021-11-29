package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {


    private Matcher getMatcher(String input, String pattern)
    {
        return Pattern.compile(pattern).matcher(input);
    }




}
