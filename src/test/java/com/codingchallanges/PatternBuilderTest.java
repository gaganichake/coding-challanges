package com.codingchallanges;

import com.codingchallanges.hashmap.AreFollowingPatterns;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PatternBuilderTest {

    AreFollowingPatterns patternBuilder;

    @BeforeEach
    public void setup(){
        patternBuilder = new AreFollowingPatterns();
    }

    @Test
    public void testCorrectPattern() {
        String[] strings = {"cat", "dog", "dog"};
        String[] patterns = {"a", "b", "b"};

        assert patternBuilder.areFollowingPatterns(strings, patterns);
    }

    @Test
    void testIncorrectPattern () {
        String[] strings = new String[] {"cat", "dog", "doggy"};
        String[] patterns = new String[] {"a", "b", "b"};

        assert !patternBuilder.areFollowingPatterns(strings, patterns);
    };

}
