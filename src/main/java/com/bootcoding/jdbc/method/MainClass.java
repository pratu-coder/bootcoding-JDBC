package com.bootcoding.jdbc.method;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        jdbcUsingMethods jdbcUsingMethod = new jdbcUsingMethods();
        List<customer> customers = jdbcUsingMethod.getAllCustomers();
        printAllCustomer(customers);
    }

    private static void printAllCustomer(List<customer> customers) {
        for(customer cust : customers){
            System.out.println(cust.getCustomerid());
            System.out.println(cust.getName());
            System.out.println(cust.getCity());
            System.out.println(cust.getEmail());
            System.out.println(cust.getSalesmanId());
            System.out.println();
        }
    }
}
