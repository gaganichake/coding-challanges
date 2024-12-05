package com.codingchallanges;

import com.codingchallanges.hashtable.PatternBuilderKimberlyMcLeod;
import org.junit.jupiter.api.Test;

public class PatternBuilderKimberlyMcLeodTest {

    PatternBuilderKimberlyMcLeod patternBuilder = new PatternBuilderKimberlyMcLeod();

        String[] testStrings = new String[2];
        String[] testPattern = new String[2];


    @Test
    public void patternMatches(){
        testStrings[0] = "hi";
        testPattern[0] = "a";
        assert patternBuilder.isFollowingPatterns(testStrings, testPattern) == true;
    }

    @Test
    public void patternDoesNotMatch(){
        testStrings[0] = "hi";
        testStrings[1] = "hi";
        testPattern[0] = "a";
        testPattern[1] = "b";

        assert patternBuilder.isFollowingPatterns(testStrings, testPattern) == false;
    }



}


/*
patterns = ["a", "b", "a", "c"]

hashmap?


a -> cat

walk through arrays
add elements to hashmap
once an element doesn't match return false
otherwise return true


 */