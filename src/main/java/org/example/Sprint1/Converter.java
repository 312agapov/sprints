package org.example.Sprint1;

public class Converter {
    public void convertStepsInDay(MonthData md, int day){
        double km = md.getDaySteps()[day-1]*0.75;
        System.out.println("За день было пройдено " + km + " метров");
        float kk = (float) (md.getDaySteps()[day - 1] * 50) /1000;
        System.out.println("За день было сожжено " + kk + " килокаллорий");
    }

    public void convertStepsInMonth(MonthData md){
        float kmsum = 0;
        float kksum = 0;
        for(int i = 0; i < md.getDaySteps().length; i++){
            kmsum = (float) (kmsum + md.getDaySteps()[i]*0.75);
            kksum = kksum + (float) md.getDaySteps()[i] /200;
        }
        System.out.println("За месяц было пройдено " + kmsum + " метров");
        System.out.println("За месяц было сожжено " + kksum + " килокаллорий");
    }

}
