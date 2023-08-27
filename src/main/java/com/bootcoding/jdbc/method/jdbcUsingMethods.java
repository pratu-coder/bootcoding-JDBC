package com.bootcoding.jdbc.method;

import com.bootcoding.jdbc.utils.DBConnectionUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class jdbcUsingMethods {

    public List<customer> getAllCustomers(){
        try{
            Connection connection = DBConnectionUtils.getConnection();
             Statement statement = connection.createStatement();
             String query = "SELECT * FROM CUSTOMER";
             ResultSet rs = statement.executeQuery(query);

             List<customer> customers = new ArrayList<>();
             while(rs.next()) {
                 int custId = rs.getInt("customer_id");
                 String name = rs.getString("cust_name");
                 String city = rs.getString("city");
                 String email = rs.getString("email");
                 int salesman_id = rs.getInt("salesman_id");

                 customer customer = new customer();
                 customer.setCustomerid(custId);
                 customer.setName(name);
                 customer.setCity(city);
                 customer.setEmail(email);
                 customer.setSalesmanId(salesman_id);

                 customers.add(customer);
             }
                 return customers;

        }
        catch(Exception ex){
            ex.printStackTrace();

        }
        return null;
    }

}
