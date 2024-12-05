package com.codingchallanges;

import com.codingchallanges.hashtable.PatternBuilderLuisFernando;
import org.junit.jupiter.api.Test;

public class PatternBuilderLuisFernandoTest {

    PatternBuilderLuisFernando patternBuilder = new PatternBuilderLuisFernando();


    @Test
    void arrayMatchPatternTest() {
        final String[] pattern = { "a", "a", "b", "a"};
        final String[] input = { "house", "house", "room", "house"};
        final String[] input2 = { "car", "car", "plane", "car"};
        assert(patternBuilder.isFollowingPatterns(input, pattern));
        assert(patternBuilder.isFollowingPatterns(input2, pattern));
    }


    @Test
    void arrayDoesntMatchPatternTest() {
        final String[] pattern = { "a", "a", "b", "a"};
        final String[] wrongInput1 = { "house", "room", "house", "house"};
        final String[] wrongInput2 = { "house", "house", "room", "room"};
        final String[] wrongInput3 = { "car", "car", "plain", "ship"};
        assert(!patternBuilder.isFollowingPatterns(wrongInput1, pattern));
        assert(!patternBuilder.isFollowingPatterns(wrongInput2, pattern));
        assert(!patternBuilder.isFollowingPatterns(wrongInput3, pattern));
    }


    @Test
    void arraySizesDontMatchTest() {
        final String[] pattern = { "a", "a", "b", "a"};
        final String[] input = { "house", "house", "room"};
        final String[] input2 = { "car", "car", "plane", "car", "car"};
        final String[] input3 = { };
        assert(!patternBuilder.isFollowingPatterns(input, pattern));
        assert(!patternBuilder.isFollowingPatterns(input2, pattern));
        assert(!patternBuilder.isFollowingPatterns(input3, pattern));
    }
}