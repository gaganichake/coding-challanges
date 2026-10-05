package com.codingchallanges.hashmap;

import java.util.*;

public class MappingPlayerScore {

    public List<Integer> solution(List<Integer> player_ids, List<Integer> player_scores, List<Integer> queries) {

        Map<Integer, Integer> playerScoreTable = new HashMap<>();

        for(int i = 0; i < player_ids.size(); i++){
            playerScoreTable.putIfAbsent(player_ids.get(i), player_scores.get(i));
        }
        List<Integer> queryResult = new ArrayList<>();

        queries.forEach(id ->
        {
            if(playerScoreTable.get(id) != null){
                queryResult.add(playerScoreTable.get(id));
            }
        });

        return queryResult;
    }
}
