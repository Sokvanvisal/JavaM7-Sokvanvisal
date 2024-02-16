/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.teachingscheduler;

/**
 *
 * @author Sokvanvisal
 */
import java.util.Scanner;
import java.sql.*;
import java.util.InputMismatchException;

public class TeachingScheduler {
    private int id;
    private String teacherName;
    private String subject;
    private String day;
    private String sTime;
    private String eTime;
    private String status;
    private String time;

    public TeachingScheduler(){
        this.id = 0;
        this.status =  "available";
        this.teacherName = "null";
        this.subject = "null";
        this.day = "null";
        this.sTime = "null";
        this.eTime = "null";
        this.time = "null";
    }
    public void addSession(int id,String teacherName,String subject,String day
                            ,String sTime,String eTime){
        this.id = id;
        this.teacherName = String.valueOf(teacherName);
        this.subject = String.valueOf(subject);
        this.day = String.valueOf(day);
        this.sTime = String.format(sTime);
        this.eTime = String.format(eTime);
        status = "unavailable";
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/periodTable","root",";-;MySQL72");
        String query1 = "INSERT INTO schedule (id, name, subject, day, sTime, eTime) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connect.prepareStatement(query1);
       
        int i,j;
        boolean loop = true;
        Scanner scan = new Scanner(System.in);
        //CREATE CONSTRUCTION OBJECT IN EACH SLOT OF ARRAY
        TeachingScheduler[][] periodTable = new TeachingScheduler[6][6];
        for( i=0 ; i < periodTable.length ; i++){
            for( j=0 ; j < periodTable[i].length ; j++){
                periodTable[i][j] = new TeachingScheduler();
            }
        }
        periodTable[0][0].time = "7:30am-8:30am";
        periodTable[1][0].time = "9:00am-10:00am";
        periodTable[2][0].time = "10:15am-11:15am";
        periodTable[3][0].time = "1:30pm-2:30pm";
        periodTable[4][0].time = "2:45pm-3:45pm";
        periodTable[5][0].time = "4:00pm-5:00pm";
        
        System.out.print("\t\t"+"Monday"+"\t\t"+"Tuesday"+"\t\t"+"Wednesday"+"\t"+"Thursday"+"\t\t"+"Friday"+"\t\t"+"Saturday"+"\n");
            for( i=0 ; i < periodTable.length ; i++){
                System.out.print(periodTable[i][0].time + "\t"+periodTable[i][0].status + "\t"+periodTable[i][1].status + "\t"+periodTable[i][2].status +"\t"+periodTable[i][3].status + "\t"+periodTable[i][4].status + "\t"+periodTable[i][5].status );
                System.out.println();
            }
    while(loop){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("1. Create schedule.");
        System.out.println("2. Show period table availability.");
        System.out.println("3. Show detailed period table.");
        System.out.println("4. Delete schedule.");
        System.out.println("5. Update schedule.");
        System.out.println("6. Search with Teacher's ID.");
        System.out.println("7. Exit.");
        System.out.print("Enter your selection (1-7) : ");

    int choice = scan.nextInt();
    scan.nextLine();
    switch(choice){
        case 1 : 
        {
        System.out.print("Input ID: ");
            int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Input your name: ");
            String name = scan.nextLine();
        System.out.print("Input your teaching subject: ");
            String subject = scan.nextLine();
        System.out.print("Input your teaching day: ");
            String day = scan.nextLine();
        System.out.print("Input your starting time: ");
            String sTime = scan.nextLine();
        System.out.print("Input your ending time: ");
            String eTime = scan.nextLine();
        
        String days = day.toLowerCase();
        switch(days){
            case "monday" :
            {
                switch(sTime){
                    case "7:30" :
                        if (periodTable[0][0].status.compareToIgnoreCase("available") == 0){
                             periodTable[0][0].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                            statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();

                             break;
                        }
                        else if(periodTable[0][0].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "9:00" :
                        if (periodTable[1][0].status.compareToIgnoreCase("available") == 0){
                            periodTable[1][0].addSession(id,name, subject, day, sTime, eTime);
                            System.out.println("-----Session has been added successfully-----");
                            statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();

                        }
                        else 
                            System.out.println("This slot is Occupied...");
                        break;
                    case "10:15" :
                        if (periodTable[2][0].status.compareToIgnoreCase("available") == 0){
                            periodTable[2][0].addSession(id,name, subject, day, sTime, eTime);
                            System.out.println("-----Session has been added successfully-----");
                            statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();

                        }
                        else 
                            System.out.println("This slot is Occupied...");
                        break;
                    case "1:30" :
                        if (periodTable[3][0].status.compareToIgnoreCase("available") == 0){
                             periodTable[3][0].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();

                        }
                        else 
                            System.out.println("This slot is Occupied...");
                        break;
                    case "2:45" :
                       if (periodTable[4][0].status.compareToIgnoreCase("available") == 0){
                             periodTable[4][0].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                            
                       }
                        else 
                            System.out.println("This slot is Occupied...");
                        break;
                    case "4:00" :
                        if (periodTable[5][0].status.compareToIgnoreCase("available") == 0){
                             periodTable[5][0].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                            
                        }
                        else 
                            System.out.println("This slot is Occupied...");
                        break;
                    default : System.out.println("Cannot add schedule... Invalid starting time");
                } 
                break;
            }
            case "tuesday" : 
            {
                switch(sTime){
                    case "7:30" :
                        if (periodTable[0][1].status.compareToIgnoreCase("available") == 0){
                             periodTable[0][1].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[0][1].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "9:00" :
                        if (periodTable[1][1].status.compareToIgnoreCase("available") == 0){
                             periodTable[1][1].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[1][1].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "10:15" :
                        if (periodTable[2][1].status.compareToIgnoreCase("available") == 0){
                             periodTable[2][1].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                            statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[2][1].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "1:30" :
                        if (periodTable[3][1].status.compareToIgnoreCase("available") == 0){
                             periodTable[3][1].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[3][1].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "2:45" :
                        if (periodTable[4][1].status.compareToIgnoreCase("available") == 0){
                             periodTable[4][1].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                            
                             break;
                        }
                        else if(periodTable[4][1].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "4:00" :
                        if (periodTable[5][1].status.compareToIgnoreCase("available") == 0){
                             periodTable[5][1].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[5][1].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    default : System.out.println("Cannot add schedule... Invalid starting time");
                } 
                break;
            }
            case "wednesday" : 
            {
                switch(sTime){
                    case "7:30" :
                        if (periodTable[0][2].status.compareToIgnoreCase("available") == 0){
                             periodTable[0][2].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[0][2].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "9:00" :
                        if (periodTable[1][2].status.compareToIgnoreCase("available") == 0){
                             periodTable[1][2].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                            
                             break;
                        }
                        else if(periodTable[1][2].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "10:15" :
                        if (periodTable[2][2].status.compareToIgnoreCase("available") == 0){
                             periodTable[2][2].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[2][2].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "1:30" :
                        if (periodTable[3][2].status.compareToIgnoreCase("available") == 0){
                             periodTable[3][2].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                            
                             break;
                        }
                        else if(periodTable[3][2].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "2:45" :
                        if (periodTable[4][2].status.compareToIgnoreCase("available") == 0){
                             periodTable[4][2].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[4][2].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "4:00" :
                        if (periodTable[5][2].status.compareToIgnoreCase("available") == 0){
                             periodTable[5][2].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                           
                             break;
                        }
                        else if(periodTable[5][2].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    default : System.out.println("Cannot add schedule... Invalid starting time");
                } 
                break;
            }
            case "thursday" :
            {
                switch(sTime){
                    case "7:30" :
                        if (periodTable[0][3].status.compareToIgnoreCase("available") == 0){
                             periodTable[0][3].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[0][3].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "9:00" :
                        if (periodTable[1][3].status.compareToIgnoreCase("available") == 0){
                             periodTable[1][3].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                            statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[1][3].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "10:15" :
                        if (periodTable[2][3].status.compareToIgnoreCase("available") == 0){
                             periodTable[2][3].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                            
                             break;
                        }
                        else if(periodTable[2][3].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "1:30" :
                        if (periodTable[3][3].status.compareToIgnoreCase("available") == 0){
                             periodTable[3][3].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[3][3].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "2:45" :
                        if (periodTable[4][3].status.compareToIgnoreCase("available") == 0){
                             periodTable[4][3].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[4][3].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "4:00" :
                        if (periodTable[5][3].status.compareToIgnoreCase("available") == 0){
                             periodTable[5][3].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[5][3].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    default : System.out.println("Cannot add schedule... Invalid starting time");
                } 
                break;
            }
            case "friday" :
            {
                switch(sTime){
                    case "7:30" :
                        if (periodTable[0][4].status.compareToIgnoreCase("available") == 0){
                             periodTable[0][4].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                            
                             break;
                        }
                        else if(periodTable[0][4].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "9:00" :
                        if (periodTable[1][4].status.compareToIgnoreCase("available") == 0){
                             periodTable[1][4].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                            
                             break;
                        }
                        else if(periodTable[1][4].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "10:15" :
                        if (periodTable[2][4].status.compareToIgnoreCase("available") == 0){
                             periodTable[2][4].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[2][4].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "1:30" :
                        if (periodTable[3][4].status.compareToIgnoreCase("available") == 0){
                             periodTable[3][4].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                            
                             break;
                        }
                        else if(periodTable[3][4].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "2:45" :
                        if (periodTable[4][4].status.compareToIgnoreCase("available") == 0){
                             periodTable[4][4].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[4][4].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "4:00" :
                       if (periodTable[5][4].status.compareToIgnoreCase("available") == 0){
                             periodTable[5][4].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[5][4].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    default : System.out.println("Cannot add schedule... Invalid starting time");
                } 
                break;
            }
            case "saturday" :
            {
                switch(sTime){
                    case "7:30" :
                        if (periodTable[0][5].status.compareToIgnoreCase("available") == 0){
                             periodTable[0][5].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[0][5].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "9:00" :
                       if (periodTable[1][5].status.compareToIgnoreCase("available") == 0){
                             periodTable[1][5].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[1][5].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "10:15" :
                        if (periodTable[2][5].status.compareToIgnoreCase("available") == 0){
                             periodTable[2][5].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                            
                             break;
                        }
                        else if(periodTable[2][5].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "1:30" :
                        if (periodTable[3][5].status.compareToIgnoreCase("available") == 0){
                             periodTable[3][5].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[3][5].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "2:45" :
                        if (periodTable[4][5].status.compareToIgnoreCase("available") == 0){
                             periodTable[4][5].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[4][5].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    case "4:00" :
                        if (periodTable[5][5].status.compareToIgnoreCase("available") == 0){
                             periodTable[5][5].addSession(id,name, subject, day, sTime, eTime);
                             System.out.println("-----Session has been added successfully-----");
                             statement.setInt(1, id); 
                            statement.setString(2, name); 
                            statement.setString(3, subject); 
                            statement.setString(4, day); 
                            statement.setString(5, sTime); 
                            statement.setString(6, eTime);
                            statement.executeUpdate();
                             
                             break;
                        }
                        else if(periodTable[5][5].status.compareToIgnoreCase("available") != 0)
                            System.out.println("This slot is Occupied...");
                        break;
                    default : System.out.println("Cannot add schedule... Invalid starting time");
                    } 
                break;
               }
            default : System.out.println("Cannot add schedule... Invalid day input");
        }
       }break;
        case 2 :
        {
        //PRINT PERIOD TABLE STATUS
            System.out.print("\t\t"+"Monday"+"\t\t"+"Tuesday"+"\t\t"+"Wednesday"+"\t"+"Thursday"+"\t\t"+"Friday"+"\t\t"+"Saturday"+"\n");
            for( i=0 ; i < periodTable.length ; i++){
                System.out.print(periodTable[i][0].time + "\t"+periodTable[i][0].status + "\t"+periodTable[i][1].status + "\t"+periodTable[i][2].status +"\t"+periodTable[i][3].status + "\t"+periodTable[i][4].status + "\t"+periodTable[i][5].status );
                System.out.println();
            }
        }break;
        case 3 :
        {
        //PRINT PERIOD TABLE
            System.out.print("\t\t"+"Monday"+"\t\t"+"Tuesday"+"\t\t"+"Wednesday"+"\t"+"Thursday"+"\t\t"+"Friday"+"\t\t"+"Saturday"+"\n");
            for( i=0 ; i < periodTable.length ; i++){
                System.out.print(periodTable[i][0].time + "\t" + periodTable[i][0].id +" "+ periodTable[i][0].teacherName +" "+ periodTable[i][0].subject + " " +"\t" +periodTable[i][1].id +" "+periodTable[i][1].teacherName +" "+ periodTable[i][1].subject+ 
                        " " +"\t"+periodTable[i][2].id +" "+ periodTable[i][2].teacherName +" "+ periodTable[i][2].subject +" "+"\t"+periodTable[i][3].id+" "+periodTable[i][3].teacherName +" "+ periodTable[i][3].subject +" "+
                        "\t"+ periodTable[i][4].id +" "+periodTable[i][4].teacherName +" "+ periodTable[i][4].subject +" " + "\t" +periodTable[i][5].id +" "+ periodTable[i][5].teacherName +" "+ periodTable[i][5].subject);
                System.out.println();
            }
        }break;
        case 4 :
        {
            int row = 0;
            int col = 0;
            System.out.print("input day: ");
                String day = scan.nextLine();
            System.out.print("input Starting time: ");
                String stime = scan.nextLine();
            day = day.toLowerCase();
            
            switch(day){
                case "monday" :
                {
                    col = 0;
                    switch(stime){
                        case "7:30": 
                            row = 0;
                            break;
                        case "9:00":
                            row = 1;
                            break;
                        case "10:15":
                            row = 2;
                            break;
                        case "1:30":
                            row = 3;
                            break;
                        case "2:45":
                            row = 4;
                            break;
                        case "4:00":
                            row = 5;
                            break;
                        default:
                            System.out.println("Schedule doesn't exist... invalid time input");
                            break;
                    }
                }break;
                case "tuesday":
                {
                    col = 1;
                    switch(stime){
                        case "7:30": 
                            row = 0;
                            break;
                        case "9:00":
                            row = 1;
                            break;
                        case "10:15":
                            row = 2;
                            break;
                        case "1:30":
                            row = 3;
                            break;
                        case "2:45":
                            row = 4;
                            break;
                        case "4:00":
                            row = 5;
                            break;
                        default:
                            System.out.println("Schedule doesn't exist... invalid time input");
                            break;
                    }
                }break;
                case "wednesday" :
                {
                    col = 2;
                    switch(stime){
                        case "7:30": 
                            row = 0;
                            break;
                        case "9:00":
                            row = 1;
                            break;
                        case "10:15":
                            row = 2;
                            break;
                        case "1:30":
                            row = 3;
                            break;
                        case "2:45":
                            row = 4;
                            break;
                        case "4:00":
                            row = 5;
                            break;
                        default:
                            System.out.println("Schedule doesn't exist... invalid time input");
                            break;
                    }
                }break;
                case "thursday" :
                {
                    col = 3;
                    switch(stime){
                        case "7:30": 
                            row = 0;
                            break;
                        case "9:00":
                            row = 1;
                            break;
                        case "10:15":
                            row = 2;
                            break;
                        case "1:30":
                            row = 3;
                            break;
                        case "2:45":
                            row = 4;
                            break;
                        case "4:00":
                            row = 5;
                            break;
                        default:
                            System.out.println("Schedule doesn't exist... invalid time input");
                            break;
                    }
                }break;
                    case "friday" :
                    {
                    col = 4;
                    switch(stime){
                        case "7:30": 
                            row = 0;
                            break;
                        case "9:00":
                            row = 1;
                            break;
                        case "10:15":
                            row = 2;
                            break;
                        case "1:30":
                            row = 3;
                            break;
                        case "2:45":
                            row = 4;
                            break;
                        case "4:00":
                            row = 5;
                            break;
                        default:
                            System.out.println("Schedule doesn't exist... invalid time input");
                            break;
                        }
                    
                    }break;
                    case "saturday" :
                    {
                    col = 5;
                    switch(stime){
                        case "7:30": 
                            row = 0;
                            break;
                        case "9:00":
                            row = 1;
                            break;
                        case "10:15":
                            row = 2;
                            break;
                        case "1:30":
                            row = 3;
                            break;
                        case "2:45":
                            row = 4;
                            break;
                        case "4:00":
                            row = 5;
                            break;
                        default:
                            System.out.println("Schedule doesn't exist... invalid time input");
                            break;
                        }
                    }break;   
                    default: 
                        System.out.println("Schedule doesn't exist... invalid day input");
                        break;
                }
            if(periodTable[row][col].status.compareTo("available")!=0){
                periodTable[row][col].id = 0;
                periodTable[row][col].teacherName = "null";
                periodTable[row][col].subject = "null";
                periodTable[row][col].sTime = "null";
                periodTable[row][col].eTime = "null";
                periodTable[row][col].status = "available";
                System.out.println("-----Session has been deleted successfully-----");
            }
            else  if(periodTable[row][col].status.compareTo("available")==0)
                System.out.println("-----There is no session in this space-----");
           
        }break;
        case 5 : 
        {
            boolean loops = true;
            int row = 0;
            int col = 0;
            System.out.print("input day: ");
                String day = scan.nextLine();
            System.out.print("input Starting time: ");
                String stime = scan.nextLine();
            day = day.toLowerCase();
            
            switch(day){
                case "monday" :
                {
                    col = 0;
                    switch(stime){
                        case "7:30": 
                            row = 0;
                            break;
                        case "9:00":
                            row = 1;
                            break;
                        case "10:15":
                            row = 2;
                            break;
                        case "1:30":
                            row = 3;
                            break;
                        case "2:45":
                            row = 4;
                            break;
                        case "4:00":
                            row = 5;
                            break;
                        default:
                            System.out.println("Schedule doesn't exist... invalid time input");
                            break;
                    }
                }break;
                case "tuesday":
                {
                    col = 1;
                    switch(stime){
                        case "7:30": 
                            row = 0;
                            break;
                        case "9:00":
                            row = 1;
                            break;
                        case "10:15":
                            row = 2;
                            break;
                        case "1:30":
                            row = 3;
                            break;
                        case "2:45":
                            row = 4;
                            break;
                        case "4:00":
                            row = 5;
                            break;
                        default:
                            System.out.println("Schedule doesn't exist... invalid time input");
                            break;
                    }
                }break;
                case "wednesday" :
                {
                    col = 2;
                    switch(stime){
                        case "7:30": 
                            row = 0;
                            break;
                        case "9:00":
                            row = 1;
                            break;
                        case "10:15":
                            row = 2;
                            break;
                        case "1:30":
                            row = 3;
                            break;
                        case "2:45":
                            row = 4;
                            break;
                        case "4:00":
                            row = 5;
                            break;
                        default:
                            System.out.println("Schedule doesn't exist... invalid time input");
                            break;
                    }
                }break;
                case "thursday" :
                {
                    col = 3;
                    switch(stime){
                        case "7:30": 
                            row = 0;
                            break;
                        case "9:00":
                            row = 1;
                            break;
                        case "10:15":
                            row = 2;
                            break;
                        case "1:30":
                            row = 3;
                            break;
                        case "2:45":
                            row = 4;
                            break;
                        case "4:00":
                            row = 5;
                            break;
                        default:
                            System.out.println("Schedule doesn't exist... invalid time input");
                            break;
                    }
                }break;
                    case "friday" :
                    {
                    col = 4;
                    switch(stime){
                        case "7:30": 
                            row = 0;
                            break;
                        case "9:00":
                            row = 1;
                            break;
                        case "10:15":
                            row = 2;
                            break;
                        case "1:30":
                            row = 3;
                            break;
                        case "2:45":
                            row = 4;
                            break;
                        case "4:00":
                            row = 5;
                            break;
                        default:
                            System.out.println("Schedule doesn't exist... invalid time input");
                            break;
                        }
                    }break;
                    case "saturday" :
                    {
                    col = 5;
                    switch(stime){
                        case "7:30": 
                            row = 0;
                            break;
                        case "9:00":
                            row = 1;
                            break;
                        case "10:15":
                            row = 2;
                            break;
                        case "1:30":
                            row = 3;
                            break;
                        case "2:45":
                            row = 4;
                            break;
                        case "4:00":
                            row = 5;
                            break;
                        default:
                            System.out.println("Schedule doesn't exist... invalid time input");
                            break;
                    }
                }break;
                    default: 
                        System.out.println("Schedule doesn't exist... invalid day input");
                        break;
            }

            TeachingScheduler schedule = new TeachingScheduler();
            schedule = periodTable[row][col];
            while(loops){
            System.out.println("Selected schedule: ");
            System.out.println("ID: " + schedule.id);
            System.out.println("Name: " + schedule.teacherName);
            System.out.println("Subject: " + schedule.subject);

            System.out.println("1. ID ");
            System.out.println("2. Name ");
            System.out.println("3. Subject");
            System.out.println("4. Save and Exit");
            System.out.print("Please Select what you want to update (1-4) :  ");
            
            int select = scan.nextInt();
            scan.nextLine();
            switch(select){
                case 1 :
                {
                    System.out.print("Input new id: ");
                        int newId = scan.nextInt();
                    periodTable[row][col].id = newId;  
                    System.out.println("-----ID has been updated successfully-----");
                }break;
                case 2 :
                {
                    System.out.print("Input new name: ");
                        String newName = scan.nextLine();
                    periodTable[row][col].teacherName = String.valueOf(newName); 
                    System.out.println("-----Name has been updated successfully-----");
                }break;
                case 3 :
                {
                    System.out.print("Input new subject: ");
                        String newSub = scan.nextLine();
                    periodTable[row][col].subject = String.valueOf(newSub);
             
                    System.out.println("-----Subject has been updated successfully-----");
                }break;
                case 4:
                {
                    loops = false;
                }break;
                default:
                   System.out.println("Invalid options... Please select between 1-4");
                   break;
            }    
        }
    }
        break;
        case 6 :{
            System.out.print("Input ID: ");
                int id = scan.nextInt();
            for( i=0 ; i < periodTable.length ; i++){
                for( j=0 ; j < periodTable[i].length ; j++){
                    if(periodTable[i][j].id == id){
                        System.out.println("Name: " + periodTable[i][j].teacherName + " ");
                        System.out.println("Subject: " + periodTable[i][j].subject + " ");
                        System.out.println("Starting time: "+ periodTable[i][j].sTime + " ");
                        System.out.println("Ending time: " + periodTable[i][j].eTime);
                        System.out.println("Teaching day: " + periodTable[i][j].day);
                        System.out.println("--------------------------------------"); 
                    }
                }
            }
        }break;
        case 7 :{
            loop = false;
            statement.close();
            connect.close();
            break;
        }
        default : 
            System.out.println("Invalid option...Please select between 1-7");
            }
        }
        }
        catch(InputMismatchException ex){
            ex.toString();
            System.out.println("Wrong format " + ex);
        }
    }
}

