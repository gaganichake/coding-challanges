package com.codingchallanges;

import com.codingchallanges.hashtable.AreFollowingPatterns;
import org.junit.jupiter.api.Test;

public class PatternBuilderTest {

    AreFollowingPatterns patternBuilder;

    @Test
    public void testCorrectPattern() {
        String[] strings = {"cat", "dog", "dog"};
        String[] patterens = {"a", "b", "c"};

        patternBuilder = new AreFollowingPatterns();

        boolean result = patternBuilder.areFollowingPatterns(strings, patterens);
        assert result == true;
    }

}