package com.bootcoding.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserJdbcExample {
    public static void main(String[] args) {
        try {
            //1.Load jdbc driver
            Class.forName("org.postgresql.Driver");


            //2.Get database connection object

            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "pratu@123");

            //3.Query database using statement object
            Statement stmt = conn.createStatement() ;

            //4.Execute query and get ResultSet
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer");

            while(rs.next()){
                //Single row
                int custId = rs.getInt("customer_id");
                //int custId2 = rs.getInt(1);
                String name = rs.getString("cust_name");
                String city = rs.getString("city");
                String email = rs.getString ("email");

                System.out.println("Id =" + custId);
                System.out.println("Name =" +name);
                System.out.println("City =" + city);
                System.out.println("Email =" + email);
            }
            //5.Connection close
            conn.close();

        }catch (Exception ex){
            ex.printStackTrace();

        }
    }
}
