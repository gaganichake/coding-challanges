package com.codingchallanges.designing;

import java.util.List;
import java.util.ArrayList;

public class DataStoreRetriever {
    private DataStore store = null;

    public DataStoreRetriever(DataStore store) {
        this.store = store;
    }

    public List<Observation> retrieveRecent(long customerId, long currTime) {
        List<Observation> result = new ArrayList<Observation>();
        for (long index = 0; index < 5; ++index) {
            Observation val = this.store.retrieve(customerId, currTime - 5 + index);
            if (val != null) {
                result.add(val);
            }
        }
        return result;
    }
}
