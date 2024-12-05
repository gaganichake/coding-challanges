package com.codingchallanges;

import com.codingchallanges.hashtable.PatternBuilderJonatanMartinez;
import org.junit.jupiter.api.Test;

public class PatternBuilderJonatanMartinezTest {

    PatternBuilderJonatanMartinez patternBuilder = new PatternBuilderJonatanMartinez();

    @Test
    public void testCorrectStringPattern(){
        String[] correctStrings = {"cat", "dog", "dog"};
        String[] correctPattern = {"a", "b", "b"};
        boolean result = patternBuilder.isFollowingPatterns(correctStrings, correctPattern);

        assert result;
    }

    @Test
    public void testIncorrectStringPattern(){
        String[] correctStrings = {"cat", "dog", "doggy"};
        String[] correctPattern = {"a", "b", "b"};
        boolean result = patternBuilder.isFollowingPatterns(correctStrings, correctPattern);

        assert !result;
    }

    @Test
    public void testMissingMemberStringPattern(){
        String[] correctStrings = {"cat", "dog"};
        String[] correctPattern = {"a", "b", "b"};
        boolean result = patternBuilder.isFollowingPatterns(correctStrings, correctPattern);

        assert result;
    }

}