package com.codingchallanges;


import com.codingchallanges.hashtable.PatternBuilderXiaoPingHuynh;
import org.junit.jupiter.api.Test;

class PatternBuilderXiaoPingHuynhTest {

    private PatternBuilderXiaoPingHuynh patternBuilder = new PatternBuilderXiaoPingHuynh();

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
        return patternBuilder.evaluateStringPattern(strings, patterns) == expected;
    }
}