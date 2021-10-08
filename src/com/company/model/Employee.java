package com.company.model;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public  class Employee{//обьявил абстрактным

    private String name;

    public Employee() {

    }

    public void setName(String name) {
        this.name = name;
    }

    private LocalDate dateOfBirth;

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    private LocalDate dateOfApplying;

    public void setDateOfApplying(LocalDate dateOfApplying) {
        this.dateOfApplying = dateOfApplying;
    }

    private BigDecimal pay;//прочитать про BigDecimal

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public Employee(String name, LocalDate dateOfBirth, LocalDate dateOfApplying, BigDecimal pay) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfApplying = dateOfApplying;
        this.pay = pay;

    }

    @Override
    public String toString() {
        return "Имя сотрудника: " + name +
                ", Дата рождения: " + dateOfBirth +
                ", Дата принятия: " + dateOfApplying +
                ", Зарплата: " + pay;
    }
}
