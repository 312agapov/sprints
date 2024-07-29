package org.example.Sprint2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class YearReport {
    int month;
    int amount;
    boolean isExpense;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isExpense() {
        return isExpense;
    }

    public void setExpense(boolean expense) {
        isExpense = expense;
    }

    @Override
    public String toString() {
        return "YearReport{" +
                "month=" + month +
                ", amount=" + amount +
                ", isExpense=" + isExpense +
                '}';
    }

    public List<YearReport> fileReader(String fileName) {
        List<YearReport> list = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            list = new ArrayList<>();
            String line;
            int income = 0;
            int outcome = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                YearReport yr = new YearReport();
                String[] params = line.split(",");
                yr.setMonth(Integer.parseInt(params[0]));
                yr.setAmount(Integer.parseInt(params[1]));
                if (Objects.equals(params[2], "TRUE")) {
                    yr.setExpense(true);
                    income = income + Integer.parseInt(params[1]);
                } else if (Objects.equals(params[2], "FALSE")) {
                    yr.setExpense(false);
                    outcome = outcome + Integer.parseInt(params[1]);
                }
                list.add(yr);
            }
            System.out.println("Прибыль: " + income + " Убыток: " + outcome);
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
            e.printStackTrace();
        }
        return list;
    }

    public void checkReports(List<YearReport> yr, List<MonthlyReport> mr) {
        int sumIncomeYear = 0;
        int sumOutcomeYear = 0;
        int sumIncomeMonths = 0;
        int sumOutcomeMonths = 0;
        for (int i = 0; i < yr.size(); i++) {
            if (yr.get(i).isExpense() == true) {
                sumIncomeYear = sumIncomeYear + yr.get(i).getAmount();
            } else if (yr.get(i).isExpense() == false) {
                sumOutcomeYear = sumOutcomeYear + yr.get(i).getAmount();
            }
        }
        for (int i = 0; i < mr.size(); i++) {
            if (mr.get(i).isExpense() == true) {
                sumIncomeMonths = sumIncomeMonths + mr.get(i).getPriceOfOne() * mr.get(i).getQuantity();
            } else if (mr.get(i).isExpense() == false) {
                sumOutcomeMonths = sumOutcomeMonths + mr.get(i).getPriceOfOne() * mr.get(i).getQuantity();
            }
        }
        System.out.println(sumIncomeYear);
        System.out.println(sumOutcomeYear);
        System.out.println(sumIncomeMonths);
        System.out.println(sumOutcomeMonths);
        if(sumIncomeYear == sumIncomeMonths && sumOutcomeYear == sumOutcomeMonths){
            System.out.println("Все ровно");
        } else {
            System.out.println("Бухгалтеру конец");
        }
    }
}
