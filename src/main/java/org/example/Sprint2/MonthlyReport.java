package org.example.Sprint2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MonthlyReport {

    String itemName;
    boolean isExpense;
    int quantity;
    int priceOfOne;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isExpense() {
        return isExpense;
    }

    public void setExpense(boolean expense) {
        isExpense = expense;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPriceOfOne() {
        return priceOfOne;
    }

    public void setPriceOfOne(int priceOfOne) {
        this.priceOfOne = priceOfOne;
    }

    @Override
    public String toString() {
        return "MonthlyReport{" +
                "itemName='" + itemName + '\'' +
                ", isExpence=" + isExpense +
                ", quantity=" + quantity +
                ", priceOfOne=" + priceOfOne +
                '}';
    }

    public void fileWriter(int[] mass){
        try {
            FileWriter fileWriter = new FileWriter("monthly1.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(int i=0; i<mass.length; i++){
                bufferedWriter.write(mass[i] + " ");
            }

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }
    }

    public List<MonthlyReport> fileReader(String fileName) {
        MonthlyReport mr = null;
        List<MonthlyReport> list = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            list = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                mr = new MonthlyReport();
                String[] params = line.split(",");
                mr.setItemName(params[0]);
                if (Objects.equals(params[1], "TRUE")) {
                    mr.setExpense(true);
                } else if (Objects.equals(params[1], "FALSE")) {
                    mr.setExpense(false);
                }
                mr.setQuantity(Integer.parseInt(params[2]));
                mr.setPriceOfOne(Integer.parseInt(params[3]));
                list.add(mr);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
            e.printStackTrace();
        }
        return list;
    }
}
