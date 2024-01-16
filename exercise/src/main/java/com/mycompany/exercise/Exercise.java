/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 1*/

package com.mycompany.exercise;

/**
 *
 * @author Sokvanvisal
 */
import java.util.Scanner;
public class Exercise {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
    System.out.println("Temperature Converter");
    System.out.println("1. C to F");
    System.out.println("2. F to c");
    System.out.println("Select your option");
    
    int choice = scanner.nextInt();
    
    if(choice == 1){
        System.out.print("enter temperature: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = cToF(celsius);
        System.out.println("Temperature in Fahrenheit : " + fahrenheit);
        
    }else if(choice == 2){
        System.out.println("enter temperature: ");
        double fahrenheit = scanner.nextDouble();
        double celsius = fToC(fahrenheit);
        System.out.println("Temperature in Celsius : " + celsius);
    }else{
        System.out.println("Invalid Selection");
        }
    }
    public static double cToF(double celsius){
        return (celsius * 9 / 5) + 32;
        }
    public static double fToC(double fahrenheit){
        return (fahrenheit -32) * 5 / 9;
    }
}