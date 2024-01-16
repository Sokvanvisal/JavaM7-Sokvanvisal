/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exercise;

/**
 *
 * @author Sokvanvisal
 */
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
public class dateConvert {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter date (YYYY-MM-DD) : ");
        String shortDate = scan.nextLine();
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        LocalDate date = LocalDate.parse(shortDate,format);
        
        int yr = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        
        String nameMonth = getMonthName(month);
//        DayOfWeek dayOfWeek = date.getDayOfWeek();
//        String dayOfWeekName = dayOfWeek.toString();
        
        String longDate = String.format("%s %d, %d", nameMonth,day,yr);
        System.out.println("output: "+ longDate);
    }
    public static String getMonthName(int month){
        switch (month){
            case 1 :
                return "January";
            case 2 :
                return "February";
            case 3 :
                return "March";
            case 4 :
                return "April";
            case 5 :
                return "May";
            case 6 :
                return "June";
            case 7 :
                return "July";
            case 8 :
                return "August";
            case 9 :
                return "September";
            case 10 :
                return "October";
            case 11 :
                return "November";
            case 12 :
                return "December";   
            default :
                return "";
        }
    }
}
