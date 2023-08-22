package com.bootcoding.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectJdbcExample {
    public static void main(String[] args) {
        try{
            //1.load jdbc driver
            Class.forName("org.postgresql.Driver");

            // 2. Get Database Connection Object
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "pratu@123");

            //3.query database using statement object
            Statement stmt = conn.createStatement();

            //4.execute query and get ResultSet
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer where city= 'Yongqin' ");

            //Extract result
            while(rs.next()){
                //Single row
                int custId = rs.getInt("customer_id");
                //int custId2 = rs.getInt(1);
                String name = rs.getString("cust_name");
                String city = rs.getString("city");
                String email = rs.getString ("email");
                int salesman_id = rs.getInt("salesman_id");

                System.out.println("Id =" + custId);
                System.out.println("Name =" +name);
                System.out.println("City =" + city);
                System.out.println("Email =" + email);
                System.out.println("salesman_id=" + salesman_id);
            }
            //5.Connection close
            conn.close();

        }catch (Exception ex){
            ex.printStackTrace();

        }
    }
}


