/*  Created by IntelliJ IDEA.
 *  User: Divyansh Bhardwaj (dbc2201)
 *  Date: 21/08/20
 *  Time: 3:50 PM
 *  File Name : FrontDesk.java
 * */
package execution;

import definitions.Student;

import java.util.Scanner;

public class FrontDesk {

    private static Scanner scannerObject = new Scanner(System.in);
    private static final String LIBRARIAN_PASSWORD = "Librarian123";

    public static void main(String[] args) {


        System.out.println("Enter 1 for Librarian login");
        System.out.println("Enter 2 for Student login");
        System.out.println("Enter 3 to exit");
        boolean quit = false;
        while(!quit){
            int loginAccessType = scannerObject.nextByte();
            switch (loginAccessType){
                case 1:
                    System.out.println("Enter password");
                    if(scannerObject.next().equals(LIBRARIAN_PASSWORD)) {
                        System.out.println("Access granted");
                        printFunctionsAvailableForLibrarian();
                        byte librarianChoice = scannerObject.nextByte();
                        boolean quitAsLibrarian = false;
                        while (!quitAsLibrarian) {
                            switch (librarianChoice) {
                                case 1:
                                    // call method to add book to the availablr books in library
                                    break;
                                case 2:
                                    // call method to remove book from the available book in the library
                                    break;
                                case 3:
                                    quitAsLibrarian = true;
                                    break;
                                default:
                                    System.out.println("Invalid input");
                            }
                        }
                    }
                    else
                        System.out.println("Invalid user");
                    break;
                case 2:
                    printFunctionsAvailableForStudent();
                    byte studentChoice = scannerObject.nextByte();
                    boolean quitAsStudent = false;
                    while (!quitAsStudent) {
                        switch (studentChoice){
                            case 1:
                                // call method to issue a book
                                break;
                            case 2:
                                // call method to return a book
                                break;
                            case 3:
                                // call method to show all the previously issued books
                                break;
                            case 4:
                                quitAsStudent = true;
                                break;
                            default:
                                System.out.println("Invalid input");
                        }
                    }
                    // give access to methods designed for students
                    break;
                case 3:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }


    public static void printFunctionsAvailableForStudent(){
        System.out.println("-=-=--=-=-\"Welcome To The Front Desk\"-=-=--=-=-\n");
        System.out.println("How may I help you today?");
        System.out.println("1. Issue a new book for me.");
        System.out.println("2. Return a previously issues book for me.");
        System.out.println("3. Show me all my issues books.");
        System.out.println("4. Exit.");

    }

    public static void printFunctionsAvailableForLibrarian(){
        System.out.println("-=-=--=-=-\"Welcome To The Front Desk\"-=-=--=-=-\n");
        System.out.println("How may I help you today?");
        System.out.println("1. Add book to the library");
        System.out.println("2. Remove book from library");
    }
}

