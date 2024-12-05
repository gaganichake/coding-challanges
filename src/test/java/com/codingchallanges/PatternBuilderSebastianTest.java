package com.codingchallanges;

import com.codingchallanges.hashtable.PatternBuilderSebastian;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PatternBuilderSebastianTest {

    PatternBuilderSebastian patternBuilder;

    @BeforeEach
    public void setUp(){
        patternBuilder = new PatternBuilderSebastian();
    }

    @Test
    public void successful_isFollowingPatterns() throws Exception{
        String [] strings = {"cat", "dog", "dog"};
        String [] pattern =  {"a", "b", "b"};

        assert patternBuilder.isFollowingPatterns(strings, pattern) == true;
    }


    @Test
    public void fail_isFollowingPatterns() throws Exception{
        String [] strings = {"cat", "dog", "doggy"};
        String [] pattern =  {"a", "b", "b"};

        assert patternBuilder.isFollowingPatterns(strings, pattern) == false;
    }



}