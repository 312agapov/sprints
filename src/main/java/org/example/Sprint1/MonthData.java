package org.example.Sprint1;

import java.util.Scanner;

public class MonthData {
    private int[] daySteps = new int[30];

    public int[] getDaySteps() {
        return daySteps;
    }

    public void setDaySteps(int[] daySteps) {
        this.daySteps = daySteps;
    }

    private int stepTarget = 10000;

    public int getStepTarget() {
        return stepTarget;
    }

    public void setStepTarget(){
        System.out.println("Введите планку по количеству шагов:");
        Scanner sc = new Scanner(System.in);
        int sT = sc.nextInt();
        while (sT < 0 ) {
            System.out.println("Число шагов введено неверно, попробуйте еще раз");
            sT = sc.nextInt();
        }
        stepTarget = sT;
    }

    public void showAllSteps(){
        System.out.println("Статистика шагов за месяц:");
        for (int i = 0; i < daySteps.length; i++){
            int day = i+1;
            System.out.println("День " + day +": " + daySteps[i]);
        }
    }

    public void addStepsAtDay(){
        System.out.println("Введите день:");
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        while(day <= 0){
            System.out.println("Введен некорректное число дня меясца! Введите еще раз");
            day = sc.nextInt();
        }
        System.out.println("Введите количество шагов, которое вы прошли в этот день");
        int steps = sc.nextInt();
        while(steps <= 0){
            System.out.println("Введен некорректное число шагов! Введите еще раз");
            steps = sc.nextInt();
        }
        daySteps[day-1] = steps;
        showAllSteps();
    }

    public void countStepsInMonth(){
        System.out.println("Статистика по количеству пройденных шагов за месяц");
        int sum = 0;
        for (int i = 0; i < daySteps.length; i++){
            sum= sum+daySteps[i];
        }
        System.out.println(sum);
    }

    public void maxStepsInMonth(){
        System.out.println("Статистика по максимальному кол-ву пройденных шагов за месяц");
        int max = 0;
        for (int i = 0; i < daySteps.length; i++){
            if (daySteps[i] > max){
                max = daySteps[i];
            }
        }
        System.out.println(max);
    }


}
