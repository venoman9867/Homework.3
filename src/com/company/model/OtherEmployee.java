package com.company.model;

import java.math.BigDecimal;
import java.time.LocalDate;


public class OtherEmployee extends Employee{
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfApplying;
    private BigDecimal pay;//прочитать про BigDecimal


    public OtherEmployee(String name, LocalDate dateOfBirth, LocalDate dateOfApplying, BigDecimal pay) {
        super(name, dateOfBirth, dateOfApplying, pay);
    }
}
