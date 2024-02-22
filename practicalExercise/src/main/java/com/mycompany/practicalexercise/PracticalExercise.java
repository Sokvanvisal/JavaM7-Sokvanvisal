/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.practicalexercise;

/**
 *
 * @author Sokvanvisal
 */     
import java.util.Scanner;

public class PracticalExercise {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        int[] numberlist = new int[50]; 

        int num = 0;
        while (num >= 0) {
            System.out.print("Input your number or input negative number to exit: ");
            num = scan.nextInt();
            if (num >= 0) {
                numberlist[i] = num;
                i++;
            }
        }
        for (int j = 0; j < i; j++) {
            System.out.print(numberlist[j] + " ");
        }
    }
}          


