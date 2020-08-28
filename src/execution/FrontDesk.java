/*  Created by IntelliJ IDEA.
 *  User: Divyansh Bhardwaj (dbc2201)
 *  Date: 21/08/20
 *  Time: 3:50 PM
 *  File Name : FrontDesk.java
 * */
package execution;

import definitions.Book;
import definitions.Library;
import definitions.Student;

import java.util.Arrays;
import java.util.Scanner;

public class FrontDesk {

    private static final String LIBRARIAN_PASSWORD = "Librarian123";
    private static Scanner scannerObject = new Scanner(System.in);
    private static Library library = new Library();

    public static void main(String[] args) {

        System.out.println("-=-=--=-=-\"Welcome To The Front Desk\"-=-=--=-=-\n");
        printLoginAccessType();

        boolean quit = false;
        while (!quit) {
            int loginAccessType = scannerObject.nextByte();
            switch (loginAccessType) {
                case 1:
                    System.out.println("Enter password");
                    if (scannerObject.next().equals(LIBRARIAN_PASSWORD)) {
                        System.out.println("Access granted");
                        printFunctionsAvailableForLibrarian();

                        boolean quitAsLibrarian = false;
                        while (!quitAsLibrarian) {
                           byte librarianChoice = scannerObject.nextByte();
                            switch (librarianChoice) {
                                case 1:
                                    addBookToTheLibrary();
                                    // call method to add book to the available books in library
                                    printFunctionsAvailableForLibrarian();
                                    break;
                                case 2:
                                    removeBookFromTheLibrary();
                                    // call method to remove book from the available book in the library
                                    printFunctionsAvailableForLibrarian();
                                    break;
                                case 3:
                                    quitAsLibrarian = true;
                                    printLoginAccessType();
                                    break;
                                default:
                                    System.out.println("Invalid input");
                                    printFunctionsAvailableForLibrarian();
                            }
                        }
                    } else
                        System.out.println("Invalid user");
                    break;
                case 2:
                   getDetailsFromTheUser();
                    printFunctionsAvailableForStudent();
                    boolean quitAsStudent = false;
                    while (!quitAsStudent) {
                        byte studentChoice = scannerObject.nextByte();
                        switch (studentChoice) {
                            case 1:
                                issueBookFromLibrary();
                                // call method to issue a book
                                printFunctionsAvailableForStudent();
                                break;
                            case 2:
                                returnPreviouslyIssuedBook();
                                // call method to return a book
                                printFunctionsAvailableForStudent();
                                break;
                            case 3:
                                displayAllIssuedBooks();
                                // call method to show all the previously issued books
                                printFunctionsAvailableForStudent();
                                break;
                            case 4:
                                quitAsStudent = true;
                                printLoginAccessType();
                                break;
                            default:
                                System.out.println("Invalid input");
                                printFunctionsAvailableForStudent();
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



    private static void issueBookFromLibrary() {

        System.out.println("Enter the name of the book");
        String name = scannerObject.nextLine();
        scannerObject.next();
        System.out.println("Enter ISBN number");
        String ISBNNumber = scannerObject.next();
        boolean whetherBookIsIssued = library.issueBook(name, ISBNNumber);
        if (whetherBookIsIssued)
            System.out.println(name + "(" + ISBNNumber + ")" + "is issued to you. Congratulations!");
        else
            System.out.println("The requested book is not currently aailable in the library, Sorry for the inconvenience");
    }

    private static void returnPreviouslyIssuedBook() {
        System.out.println("Enter name of the book");
        String name = scannerObject.nextLine();
        scannerObject.next();
        System.out.println("Enter ISBN number");
        String ISBNNumber = scannerObject.next();
        boolean ifBookIsReturned = library.returnIssuedBook(name, ISBNNumber, getDetailsFromTheUser().getRollNumber());
        if (ifBookIsReturned)
            System.out.println("Thanks for returning the book. ");
        else
            System.out.println("No such book was issued by you. ");
    }

    private static void displayAllIssuedBooks() {
        System.out.println("Displaying all issued books by you.");
        Book[] listOfBooksIssued = new Student(getDetailsFromTheUser().getRollNumber()).getListOfBooksIssued();
        System.out.println(Arrays.toString(listOfBooksIssued));
    }

    private static void addBookToTheLibrary(){
        System.out.println("Enter name of the book");
        String nameOfTheBook = scannerObject.nextLine();
        scannerObject.next();
        System.out.println("Enter name of the author of the book");
        String nameOfAuthor = scannerObject.nextLine();
        scannerObject.next();
        System.out.println("Enter ISBN Code");
        String ISBNCode = scannerObject.next();
        library.addBookToTheLibrary(nameOfTheBook,nameOfAuthor,ISBNCode);
    }

    private static void removeBookFromTheLibrary() {
        System.out.println("Enter name of the book");
        String nameOfTheBook = scannerObject.nextLine();
        scannerObject.next();
        System.out.println("Enter name of the author of the book");
        String nameOfAuthor = scannerObject.nextLine();
        scannerObject.next();
        System.out.println("Enter ISBN Code");
        String ISBNCode = scannerObject.next();
        library.removeBookFromLibrary(nameOfTheBook,nameOfAuthor,ISBNCode);
    }


    private static Student getDetailsFromTheUser() {
        System.out.println("Enter roll number");
        return new Student(scannerObject.nextLong());
    }


    public static void printFunctionsAvailableForStudent() {
        System.out.println("How may I help you today?");
        System.out.println("1. Issue a new book for me.");
        System.out.println("2. Return a previously issues book for me.");
        System.out.println("3. Show me all my issues books.");
        System.out.println("4. Exit.");
    }

    public static void printFunctionsAvailableForLibrarian() {
        System.out.println("How may I help you today?");
        System.out.println("1. Add book to the library");
        System.out.println("2. Remove book from library");
        System.out.println("3. Exit.");
    }
    public static void printLoginAccessType() {
        System.out.println("Enter 1 for Librarian login");
        System.out.println("Enter 2 for Student login");
        System.out.println("Enter 3 to exit.");
    }
}

