package com.UseCases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.BeenClasses.CrimeDetails;
import com.DAO.CrimeDao;
import com.DAO.CrimeDaoImpl;
import com.DAO.CriminalDao;
import com.DAO.CriminalImpl;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean loggedIn = false;
        // Create objects of CrimeDao and CriminalDao
        CrimeDao crimeDao = new CrimeDaoImpl();
        CriminalDao criminalDao = new CriminalImpl();
        while (true) {
            try {
                // Display login menu
                System.out.println("Type 1 for login");
                choice = scanner.nextInt();
                scanner.nextLine();
                
                if (choice == 1) {
                	System.out.println("Enter your Username and password.");
                	String user=scanner.next();
                	String password=scanner.next();
                   loggedIn = criminalDao.login(user, password);
                    if (loggedIn) {
                        break;
                    }
                } else {
                    System.out.println("Invalid choice, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine();
            }
        }
        
        while (loggedIn) {
            try {
                // Display main menu
                System.out.println("Type 1 for add crime");
                System.out.println("Type 2 for update crime");
                System.out.println("Type 3 for get crime details");
                System.out.println("Type 4 for add criminal");
                System.out.println("Type 5 for update criminal");
                System.out.println("Type 6 for get criminal details");
                System.out.println("Type 7 to exit");
                choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice) {
                    case 1:
                    	System.out.println("Please enter crime Id");
                    	int crimeId=scanner.nextInt();
                    	System.out.println("Please enter the date of the crime (YYYY-MM-DD):");
                    	String date = scanner.nextLine();
                    	System.out.println("Please enter the place of the crime:");
                    	String place = scanner.nextLine();
                    	System.out.println("Please enter the description of the crime:");
                    	String description = scanner.nextLine();
                    	System.out.println("Please enter the number of victims:");
                    	String victims = scanner.nextLine();
                    	System.out.println("Please enter any additional details of the crime:");
                    	String details = scanner.nextLine();
                    	System.out.println("Please enter any suspected individuals:");
                    	String suspected = scanner.nextLine();
                    	System.out.println("Please enter the status of the crime (solved/unsolved):");
                    	String status = scanner.nextLine();
                    	System.out.println("Please enter the area where the crime occurred:");
                    	String area = scanner.nextLine();
                    	System.out.println("Please enter the police station responsible for the area:");
                    	String policeStation = scanner.nextLine();
                    	System.out.println("Please enter the ID of the associated criminal:");
                    	int criminalId = scanner.nextInt();

                    	CrimeDetails crime = new CrimeDetails(crimeId,date,  place,  description,  victims,  details,
                				suspected, status,  policeStation, area);
                    	crimeDao.addCrime(crime);
                        break;
                    case 2:
                        // Call updateCrime method
                        break;
                    case 3:
                        // Call searchCrime method and display results
                        break;
                    case 4:
                        // Call addCriminal method
                        break;
                    case 5:
                        // Call updateCriminal method
                        break;
                    case 6:
                        // Call searchCriminal method and display results
                        break;
                    case 7:
                        // Exit the program
                        loggedIn = false;
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
   
    
}

