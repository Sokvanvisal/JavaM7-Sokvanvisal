/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.teachingscheduler;

/**
 *
 * @author Sokvanvisal
 */


import java.sql.*;
import java.util.InputMismatchException;

public class TeachingScheduler {   
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connect;
        Statement stmt;
        ResultSet rs;
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/testing","root","MySQL72");
            System.out.println("Success!!!");
        
//          stmt = connect.createStatement();
//        String query1 = "CREATE TABLE Product (id int, name varchar(30), price_per_unit double, active_for_sell boolean)";
//        stmt.execute(query1);

        stmt = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String query = "Select * from Product";
        
        rs = stmt.executeQuery(query);
        
        while(rs.next()){
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Price_per_unit: " + rs.getDouble("price_per_unit") + "$");
            System.out.println("Active_for_sale: " + rs.getBoolean("active_for_sell"));
        }
        }
        catch(InputMismatchException ex){
            ex.toString();
            System.out.println("Wrong format " + ex);
        }
    }
}

