package com.company.service;

import com.company.model.Employee;
import com.company.model.Manager;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
public class HRdepartment implements Comparable<Manager>{
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private Employee[] employees = new Employee[1000];

    public int add(String name, LocalDate date1, LocalDate date2, BigDecimal pay) {
        if (pay.compareTo(new BigDecimal(0)) == 1) {
            if (date1.plusYears(16).isBefore(date2)) {
                for (int i = 0; i < employees.length; i++) {
                    {
                        if (employees[i] == null) {
                            employees[i] = new Employee(name, date1, date2, pay);
                            break;
                        }
                    }
                }
            } else {
                return 1;
            }
            return 0;
        } else {
            return 2;
        }
    }

    public void randomAddEmployee() {
        String[] firstNames = {"Иван", "Роберт", "Боливар", "Кристо", "Майк", "Джек", "Тонни", "Люци", "Грин", "Люк"};
        String[] familys = {"Вазовски", "Петров", "Хрущев", "Исаков", "Кудрин", "Чехов", "Калашников", "Свиридов"};
        long minDay = LocalDate.of(1998, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2021, 12, 31).toEpochDay();

        for (int i = 0; i < employees.length; i++) {
            long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
            long randomDay2 = ThreadLocalRandom.current().nextLong(minDay, maxDay);
            LocalDate randomDate1 = LocalDate.ofEpochDay(randomDay);
            LocalDate randomDate2 = LocalDate.ofEpochDay(randomDay2);
            BigDecimal randomPay = new BigDecimal(Math.random() * 1000000).setScale(2, RoundingMode.CEILING);
            String name = firstNames[(int) (Math.random() * 10)] + " " + familys[(int) (Math.random() * 8)];
            if (employees[i] == null) {
                employees[i] = new Employee(name, randomDate1, randomDate2, randomPay);
            }
        }
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void delete(int position) {
        employees[position] = null;
    }

    public void sort(){
        Arrays.sort(employees);
    }

    @Override
    public int compareTo(Manager o) {
        return 0;
    }
}
