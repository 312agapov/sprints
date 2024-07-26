package org.example.Sprint1;

import java.util.HashMap;

public class StepTracker {
    HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();

    public StepTracker(){
        for (int i = 0; i < 12; i++){
            monthToData.put(i, new MonthData());
        }
    }

}
