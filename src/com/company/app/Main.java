package com.company.app;

import com.company.model.Employee;
import com.company.model.Manager;
import com.company.service.HRdepartment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    /*Список сотрудников должен позволять добавлять, удалять,
    изменять тип сотрудника, привязывать сотрудника к менеджеру,
    сортировать список по фамилиям, датам принятия на работу
//Дз почитать про тернарные операторы, отличие между локал дэйт и дэйт, добавить проверку на null, LocalDate переделать,
//понять чем плох date от localdate
Работа в консоли должна выглядеть так:
1. Вывести список сотрудников
2. Создать сотрудника
...
0. Выход из программы*/
    //ДЗ--------
//пакеты нужны для, разбиение на слои
//избавить HRdepartment от систем аутов
//доделать метод с дополнительным классом для метода Add
//почитать еще раз про отношения классов
//добавить метод создающий менеджера из списка сотрудников, сделать обьект типа менеджер, сделать так чтобы при удалении
// сотрудника удалялся и сотрудник из массива менеджеров
// создать копию массива,там где безобидно сделать копию, где нужно изменять оставить геттер
    private static Scanner scanner = new Scanner(System.in);
    private static HRdepartment hr = new HRdepartment();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static void main(String[] args) throws Exception {
        System.out.println("Добро пожаловать!");
        int number2;
        do {
            System.out.println("Выберите действие:" +
                    "\n1.Вывести список сотрудников\n2.Создать сотрудника\n3.Удалить сотрудника\n" +
                    "4.Изменить сотрудника\n5.Создать менеджера\n" +
                    "7.Отсортировать список по фамилиям" + "\n8.Отсортировать список по датам принятия на работу" + "\n9.Заполнить БД рандомными сотрудниками" + "\n0.Выйти из программы");
            number2 = scanner.nextInt();
            scanner.nextLine();
            switch (number2){
                case 1:
                    int count = 1;
                    for (Employee value : hr.getEmployees().clone()) {
                        if (value != null) {
                            System.out.println(count + ": " + "" + value + ".");
                        }else{
                            System.out.println("Пусто.");
                            break;
                        }
                        count++;
                    }
                    break;
                case 2:
                    System.out.println("Введите ФИО сотрудника");
                    String name = scanner.nextLine();
                    System.out.println("Введите дату рождения сотрудника");
                    String sDate1 = scanner.next();
                    LocalDate Date1 = LocalDate.parse(sDate1, formatter);
                    System.out.println("Введите дату когда сотрудник был принят на работу");
                    String sDate2 = scanner.next();
                    LocalDate Date2 = LocalDate.parse(sDate2, formatter);
                    System.out.println("Введите зарплату работника");
                    BigDecimal pay = scanner.nextBigDecimal();
                    hr.add(name, Date1, Date2, pay);
                    System.out.println("Сотрудник создан!");
                    break;
                case 3:
                    System.out.println("Выберите номер сотрудника для удаления.");
                    int position = scanner.nextInt();
                    hr.delete(position);
                    System.out.println("Сотрудник удален!");
                    break;
                case 4:
                    change();
                    break;
                case 5:
                    System.out.println("Выберите номер сотрудника чтобы сделать его менеджером");
                    int position3 = scanner.nextInt();
                    //Manager mr=new Manager(hr.getEmployees()[position3]);
                   // mr.managerKit(position3);
                    break;
                case 6:
                case 7:
                    hr.sort();
                    break;
                case 9:
                    hr.randomAddEmployee();
                case 0:
                    break;
            }

        } while (number2 != 0);//bring int number 2 into scope?
    }
    public static void change(){
        System.out.println("Выберите номер сотрудника для редактирования");
        int position2 = scanner.nextInt();
        if (hr.getEmployees()[position2] != null) {
            System.out.println("Сотрудник " + hr.getEmployees()[position2] + " что вы хотите изменить?\n1.ФИО\n" +
                    "2.Дату рождения\n3.Дата принятия на работу\n4.Зарплату\n5.Если хотите выйти из редактора");
            int variant;
            do {
                variant = scanner.nextInt();
                scanner.nextLine();
                switch (variant) {
                    case 1:
                        System.out.println("Введите новое ФИО: ");
                        String change1 = scanner.nextLine();
                        hr.getEmployees()[position2].setName(change1);
                        System.out.println("Сделано! Что дальше?");
                        System.out.println("Сотрудник " + hr.getEmployees()[position2] + " что вы хотите изменить?\n1.ФИО\n2.Дату рождения\n3.Дата принятия на работу\n4.Зарплату\n5.Если хотите выйти из редактора");
                    case 2:
                        System.out.println("Введите новую дату рождения: ");
                        String s_change2 = scanner.nextLine();
                        LocalDate change2 = LocalDate.parse(s_change2, formatter);
                        hr.getEmployees()[position2].setDateOfBirth(change2);
                        System.out.println("Сделано! Что дальше?");
                        System.out.println("Сотрудник " + hr.getEmployees()[position2] + " что вы хотите изменить?\n1.ФИО\n2.Дату рождения\n3.Дата принятия на работу\n4.Зарплату\n5.Если хотите выйти из редактора");
                    case 3:
                        System.out.println("Введите новую дату принятия на работу");
                        String s_change3 = scanner.nextLine();
                        LocalDate change3 = LocalDate.parse(s_change3, formatter);
                        hr.getEmployees()[position2].setDateOfApplying(change3);
                        System.out.println("Сделано! Что дальше?");
                        System.out.println("Сотрудник " + hr.getEmployees()[position2] + " что вы хотите изменить?\n1.ФИО\n2.Дату рождения\n3.Дата принятия на работу\n4.Зарплату\n5.Если хотите выйти из редактора");
                    case 4:
                        System.out.println("Установите новую зарплату для сотрудника: ");
                        BigDecimal change4 = scanner.nextBigDecimal();
                        hr.getEmployees()[position2].setPay(change4);
                        System.out.println("Сделано! Что дальше?");
                        System.out.println("Сотрудник " + hr.getEmployees()[position2] + " что вы хотите изменить?\n1.ФИО\n2.Дату рождения\n3.Дата принятия на работу\n4.Зарплату\n5.Если хотите выйти из редактора");
                    case 5:
                        System.out.println("Редактирование сотрудника завершено!");
                }
            } while (variant != 5);
        } else {
            System.out.println("Ячейка пуста, тут нечего редактировать!");
        }
    }
}
