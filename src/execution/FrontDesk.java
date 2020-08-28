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
    private static final byte ADD_BOOK_TO_LIBRARY = 1;
    private static final byte REMOVE_BOOK_FROM_LIBRARY = 2;
    private static final byte QUIT_FROM_LIBRARIAN_ACCESS = 3;
    private static final byte LIBRARIAN_ACCESS = 1;
    private static final byte STUDENT_ACCESS = 2;
    private static final byte ISSUE_BOOK_FROM_LIBRARY = 1;
    private static final byte RETURN_ISSUED_BOOK = 2;
    private static final byte DISPLAY_ALL_ISSUED_BOOKS = 3;
    private static final byte QUIT_FROM_STUDENT_ACCESS = 4;
    private static final byte QUIT_FROM_APP = 3;
    private static Scanner scannerObject = new Scanner(System.in);
    private static Library library = new Library();

    public static void main(String[] args) {

        System.out.println("-=-=--=-=-\"Welcome To The Front Desk\"-=-=--=-=-\n");
        printLoginAccessType();

        boolean quit = false;
        while (!quit) {
            int loginAccessType = scannerObject.nextByte();
            switch (loginAccessType) {
                case LIBRARIAN_ACCESS:
                    System.out.println("Enter password");
                    if (scannerObject.next().equals(LIBRARIAN_PASSWORD)) {
                        System.out.println("Access granted");
                        printFunctionsAvailableForLibrarian();
                        boolean quitAsLibrarian = false;
                        while (!quitAsLibrarian) {
                            byte librarianChoice = scannerObject.nextByte();
                            switch (librarianChoice) {
                                case ADD_BOOK_TO_LIBRARY:
                                    addBookToTheLibrary();
                                    // call method to add book to the available books in library
                                    printFunctionsAvailableForLibrarian();
                                    break;
                                case REMOVE_BOOK_FROM_LIBRARY:
                                    removeBookFromTheLibrary();
                                    // call method to remove book from the available book in the library
                                    printFunctionsAvailableForLibrarian();
                                    break;
                                case QUIT_FROM_LIBRARIAN_ACCESS:
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
                case STUDENT_ACCESS:
                    getDetailsFromTheUser();
                    printFunctionsAvailableForStudent();
                    boolean quitAsStudent = false;
                    while (!quitAsStudent) {
                        byte studentChoice = scannerObject.nextByte();
                        switch (studentChoice) {
                            case ISSUE_BOOK_FROM_LIBRARY:
                                issueBookFromLibrary();
                                // call method to issue a book
                                printFunctionsAvailableForStudent();
                                break;
                            case RETURN_ISSUED_BOOK:
                                returnPreviouslyIssuedBook();
                                // call method to return a book
                                printFunctionsAvailableForStudent();
                                break;
                            case DISPLAY_ALL_ISSUED_BOOKS:
                                displayAllIssuedBooks();
                                // call method to show all the previously issued books
                                printFunctionsAvailableForStudent();
                                break;
                            case QUIT_FROM_STUDENT_ACCESS:
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
                case QUIT_FROM_APP:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    /**
     * This method is accessible to student login to issue a book from the library.
     */

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

    /**
     * This method is accessible to the student login to to return the previously issued book.
     */

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

    /**
     * This method can be accessed by the student login to display all the books that have issued by him.
     */

    private static void displayAllIssuedBooks() {
        Book[] listOfBooksIssued = new Student(getDetailsFromTheUser().getRollNumber()).getListOfBooksIssued();
        System.out.println("Displaying all issued books by you.");
        System.out.println(Arrays.toString(listOfBooksIssued));
    }

    /**
     * This method has been designed for the librarian login to add a book to the list of available books in the library.
     */

    private static void addBookToTheLibrary() {
        System.out.println("Enter name of the book");
        String nameOfTheBook = scannerObject.nextLine();
        scannerObject.next();
        System.out.println("Enter name of the author of the book");
        String nameOfAuthor = scannerObject.nextLine();
        scannerObject.next();
        System.out.println("Enter ISBN Code");
        String ISBNCode = scannerObject.next();
        library.addBookToTheLibrary(nameOfTheBook, nameOfAuthor, ISBNCode);
    }

    /**
     * This method is designed for librarian's access to remove a book from the library
     */

    private static void removeBookFromTheLibrary() {
        System.out.println("Enter name of the book");
        String nameOfTheBook = scannerObject.nextLine();
        scannerObject.next();
        System.out.println("Enter name of the author of the book");
        String nameOfAuthor = scannerObject.nextLine();
        scannerObject.next();
        System.out.println("Enter ISBN Code");
        String ISBNCode = scannerObject.next();
        library.removeBookFromLibrary(nameOfTheBook, nameOfAuthor, ISBNCode);
    }

    /**
     * This method is used to take the details from the student(mainly roll number)
     *
     * @return this method returns Student reference type.
     */


    private static Student getDetailsFromTheUser() {
        System.out.println("Enter roll number");
        return new Student(scannerObject.nextLong());
    }

    /**
     * This function is used to print the functions available for the student.
     */

    public static void printFunctionsAvailableForStudent() {
        System.out.println("How may I help you today?");
        System.out.println("1. Issue a new book for me.");
        System.out.println("2. Return a previously issues book for me.");
        System.out.println("3. Show me all my issues books.");
        System.out.println("4. Exit.");
    }

    /**
     * This function is used to print the functions available for the librarian
     */

    public static void printFunctionsAvailableForLibrarian() {
        System.out.println("How may I help you today?");
        System.out.println("1. Add book to the library");
        System.out.println("2. Remove book from library");
        System.out.println("3. Exit.");
    }

    /**
     * This function is used to print options for different types of login access.
     */

    public static void printLoginAccessType() {
        System.out.println("Enter 1 for Librarian login");
        System.out.println("Enter 2 for Student login");
        System.out.println("Enter 3 to exit.");
    }
}

