package com.codingchallanges;

import com.codingchallanges.hashmap.AreFollowingPatterns;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AreFollowingPatternsTest {

    @Test
    public void testCorrectPattern() {
        String[] strings = {"cat", "dog", "dog"};
        String[] patterns = {"a", "b", "b"};

        assert AreFollowingPatterns.areFollowingPatternsHashMap(strings, patterns);
    }

    @Test
    void testIncorrectPattern () {
        String[] strings = new String[] {"cat", "dog", "doggy"};
        String[] patterns = new String[] {"a", "b", "b"};

        assert !AreFollowingPatterns.areFollowingPatternsHashMap(strings, patterns);
    };

    @Test
    void arrayMatchPatternTest() {
        final String[] pattern = { "a", "a", "b", "a"};
        final String[] input = { "house", "house", "room", "house"};
        final String[] input2 = { "car", "car", "plane", "car"};
        assert(AreFollowingPatterns.isFollowingPatternsByLuisFernando(input, pattern));
        assert(AreFollowingPatterns.isFollowingPatternsByLuisFernando(input2, pattern));
    }

    @Test
    void arrayDoesntMatchPatternTest() {
        final String[] pattern = { "a", "a", "b", "a"};
        final String[] wrongInput1 = { "house", "room", "house", "house"};
        final String[] wrongInput2 = { "house", "house", "room", "room"};
        final String[] wrongInput3 = { "car", "car", "plain", "ship"};
        assert(!AreFollowingPatterns.isFollowingPatternsByLuisFernando(wrongInput1, pattern));
        assert(!AreFollowingPatterns.isFollowingPatternsByLuisFernando(wrongInput2, pattern));
        assert(!AreFollowingPatterns.isFollowingPatternsByLuisFernando(wrongInput3, pattern));
    }

    @Test
    void arraySizesDontMatchTest() {
        final String[] pattern = { "a", "a", "b", "a"};
        final String[] input = { "house", "house", "room"};
        final String[] input2 = { "car", "car", "plane", "car", "car"};
        final String[] input3 = { };
        assert(!AreFollowingPatterns.isFollowingPatternsByLuisFernando(input, pattern));
        assert(!AreFollowingPatterns.isFollowingPatternsByLuisFernando(input2, pattern));
        assert(!AreFollowingPatterns.isFollowingPatternsByLuisFernando(input3, pattern));
    }

    @Test
    public void successful_isFollowingPatterns() throws Exception{
        String [] strings = {"cat", "dog", "dog"};
        String [] pattern =  {"a", "b", "b"};

        assert AreFollowingPatterns.isFollowingPatternsBySebastian(strings, pattern);
    }


    @Test
    public void fail_isFollowingPatterns() throws Exception{
        String [] strings = {"cat", "dog", "doggy"};
        String [] pattern =  {"a", "b", "b"};

        assert !AreFollowingPatterns.isFollowingPatternsBySebastian(strings, pattern);
    }

    // First test:
    @Test
    void isFollowingPatternsReturnsTrue () {
        String[] inputTestOne = new String[] {"cat", "dog", "dog"};
        String[] patternTestOne = new String[] {"a", "b", "b"};


        assert AreFollowingPatterns.isFollowingPatternsByJusticeCalderon(inputTestOne, patternTestOne);
    };

    // Second test:
    @Test
    void isFollowingPatternsReturnsFalse () {
        String[] inputTestTwo = new String[] {"cat", "dog", "doggy"};
        String[] patternTestTwo = new String[] {"a", "b", "b"};

        assert !AreFollowingPatterns.isFollowingPatternsByJusticeCalderon(inputTestTwo, patternTestTwo);
    };

    // test case:
    // string ["cat", "dog", "dog"], patterns = ["a", "b", "b"] -> true
    // string ["cat", "dog", "doggy"], patterns = ["a", "b", "b"] -> false (doggy should have different pattern)
    // string ["cat"], patterns = ["a"] -> true
    // string ["cat"], patterns = ["b"] -> true
    //

    @Test
    public void runTestsSuccess() {
        // run test cases and assert result
        assert (testCase(new String[] { "cat", "dog", "dog" }, new String[] { "a", "b", "b"}, true));
    }

    @Test
    public void runTestsFailure() {
        // run test cases and assert result

        assert (testCase(new String[] { "cat", "dog", "doggy" }, new String[] { "a", "b", "b"}, false));
    }

    @Test
    public void runTestMinSize() {
        // run test cases and assert result
        assert (testCase(new String[] { "cat"}, new String[] { "a" }, true));
    }

    @Test
    public void runTestLongerPatterns() {
        // run test cases and assert result
        assert (testCase(new String[] { "cat" }, new String[] { "a", "b" }, false));
    }

    @Test
    public void runTestLongerStrings() {
        // run test cases and assert result
        assert (testCase(new String[] { "cat", "dog" }, new String[] { "a" }, false));
    }

    public boolean testCase(String[] strings, String[] patterns, boolean expected) {
        return AreFollowingPatterns.evaluateStringPatternByXiaoPingHuynh(strings, patterns) == expected;
    }
}
