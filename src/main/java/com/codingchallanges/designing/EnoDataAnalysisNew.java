package com.codingchallanges.designing;

import java.util.ArrayList;
import java.util.List;

/*
Capital One : Case interview, October 7, 2021

The DataStore and Observation classes are defined in package
    clkStore for clickstream data
    trxStore for transaction data
Both are stored at per-minute accuracy

Output:
clkRecent -
1 - 25853654 - Confirm
1 - 25853653 - Schedule Payment
1 - 25853652 - View Recent
1 - 25853651 - Login
1 - 25853650 - Enter Passowrd

trxRecent -
1 - 25853652 - Kroger $243.00

joinDataLeft -
1 - 5 - 1
2 - 1 - 0
 */
public class EnoDataAnalysisNew {

    private int aggregate(List recents) {
        if (recents != null)
            return recents.size();
        else
            return 0;
    }

    private List joinDataLeft(DataStore clkStore, DataStore trxStore) {
        DataStoreRetriever clkRetriever = new DataStoreRetriever(clkStore);
        DataStoreRetriever trxRetriever = new DataStoreRetriever(trxStore);

        ArrayList result = new ArrayList();
        long currTime = 25853654;
        List<Observation> clkRecent = null;
        List<Observation> trxRecent = null;
        for (long cid : clkStore.custIds()) {
            clkRecent = clkRetriever.retrieveRecent(cid, currTime);
            trxRecent = trxRetriever.retrieveRecent(cid, currTime);
            result.add( new DataTuple(cid, aggregate(clkRecent), aggregate(trxRecent)) );
        }
        return result;
    }

    public static void main(String args[]) {
        // Assume the clkStore and trxStore fill themselves with data and not null
        DataStore clkStore = new DataStore();
        DataStore trxStore = new DataStore();

        EnoDataAnalysisNew eda = new EnoDataAnalysisNew();
        List joinedData = eda.joinDataLeft(clkStore, trxStore);
    }
}
