package com.codingchallanges;

import com.codingchallanges.hashtable.PatternBuilderJusticeCalderon;
import org.junit.jupiter.api.Test;

public class PatternBuilderJusticeCalderonTest {

    PatternBuilderJusticeCalderon patternBuilder = new PatternBuilderJusticeCalderon();

    // First test:
    @Test
    void isFollowingPatternsReturnsTrue () {
        String[] inputTestOne = new String[] {"cat", "dog", "dog"};
        String[] patternTestOne = new String[] {"a", "b", "b"};


        assert patternBuilder.isFollowingPatterns(inputTestOne, patternTestOne);
    };

    // Second test:
    @Test
    void isFollowingPatternsReturnsFalse () {
        String[] inputTestTwo = new String[] {"cat", "dog", "doggy"};
        String[] patternTestTwo = new String[] {"a", "b", "b"};

        assert !patternBuilder.isFollowingPatterns(inputTestTwo, patternTestTwo);
    };

}
