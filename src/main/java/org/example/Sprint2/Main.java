package org.example.Sprint2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MonthlyReport mr = new MonthlyReport();
        List<MonthlyReport> mrList = new ArrayList<>();
        mrList.addAll(mr.fileReader("monthly1.txt"));
        mrList.addAll(mr.fileReader("monthly2.txt"));
        mrList.addAll(mr.fileReader("monthly3.txt"));

//        System.out.println(mrList);
        for(int i = 0; i < mrList.size(); i++){
            System.out.println(mrList.get(i));
        }
        YearReport yr = new YearReport();
        List<YearReport> yrList = yr.fileReader("year.txt");
        for(int i = 0; i < yrList.size(); i++){
            System.out.println(yrList.get(i));
        }
        yr.checkReports(yrList,mrList);

        mr.fileWriter("write1.txt",mrList);
    }
}
