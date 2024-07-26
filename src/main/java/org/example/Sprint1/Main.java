package org.example.Sprint1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker st = new StepTracker();
        int choise;
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Выберите месяц для взаимодействия, где 1 - январь, а 12 - декабрь. Завершение работы - 0");
            choise = sc.nextInt();
            while (choise < 0 || choise > 12) {
                System.out.println("Число месяца введено неверно, попробуйте еще раз");
                choise = sc.nextInt();
            }
            if(choise == 0){
                return;
            }
            System.out.println("Что вы хотите сделать?\n1-Вывести данные за этот месяц\n2-Внести данные за день" +
                    "\n3-Внести планку количества шагов\n4-Узнать пройденное расстояние и сожженые килокаллории за день" +
                    "\n5-Узнать пройденное расстояние и сожженые килокаллории за месяц");
            int choise2 = sc.nextInt();
            while (choise2 < 0 || choise2 > 5) {
                System.out.println("Число введено неверно, попробуйте еще раз");
                choise2 = sc.nextInt();
            }
            if (choise2 == 1){
                st.monthToData.get(choise-1).showAllSteps();
            }
            if (choise2 == 2){
                st.monthToData.get(choise-1).addStepsAtDay();
            }
            if (choise2 == 3){
                st.monthToData.get(choise-1).setStepTarget();
            }
            if (choise2 == 4){
                Converter cv = new Converter();
                System.out.println("Введите день для получения пройденного расстояния и количества килокаллорий");
                int day = sc.nextInt();
                while (day <= 0 || day > 30) {
                    System.out.println("Число дня введено неверно, попробуйте еще раз");
                    day = sc.nextInt();
                }
                cv.convertStepsInDay(st.monthToData.get(choise-1),day);
            }
            if (choise2 == 5){
                Converter cv = new Converter();
                cv.convertStepsInMonth(st.monthToData.get(choise-1));
            }
        }

    }
}