package com.reportes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

/**
 * Dummy
 */
public class Dummy {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2018, 5, 11);
        System.out.println(String.format("%tF", date));
        System.out.println(String.format("$%20.4f", new BigDecimal("45454555.53")));
    }


}
