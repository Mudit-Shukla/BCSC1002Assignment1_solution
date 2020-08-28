/*  Created by IntelliJ IDEA.
 *  User: Divyansh Bhardwaj (dbc2201)
 *  Date: 21/08/20
 *  Time: 3:50 PM
 *  File Name : Library.java
 * */
package definitions;

import java.util.Arrays;
import java.util.Objects;

public class Library {
    private Book[] booksAvailableInTheLibrary;
    private byte availability;

    public byte getAvailability() {
        return availability;
    }

    public void setAvailability(byte availability) {
        this.availability = availability;
    }

    public Library(Book[] booksAvailableInTheLibrary, byte availability) {
        this.booksAvailableInTheLibrary = booksAvailableInTheLibrary;
        this.availability = 1;
    }

    public Library() {
        getBooksAvailableInTheLibrary();
    }

    public Book[] getBooksAvailableInTheLibrary() {
        return booksAvailableInTheLibrary;
    }

    public void setBooksAvailableInTheLibrary(Book[] booksAvailableInTheLibrary) {
        this.booksAvailableInTheLibrary = booksAvailableInTheLibrary;
    }

    public String toString() {
        return String.format("Books available in the library : %s",
                Arrays.toString(booksAvailableInTheLibrary));
    }

    public boolean issueBook(String nameOfBook, String ISBNNumber){
        for(Book book : booksAvailableInTheLibrary)
            if(book.getISBNNumberOfBook().equals(ISBNNumber))
                if(book.getAvailability() == 1) {
                    book.setAvailability((byte) 0);
                    return true;
                }
        return false;
    }

    public boolean removeBookFromLibrary(Book bookToBeRemoved) {
        for(Book book : booksAvailableInTheLibrary)
            if(book.equals(bookToBeRemoved)){
               book.setAvailability((byte) 0);
                return true;
        }
        return false;
    }

    public boolean returnIssuedBook(String nameOfBook, String ISBNNumber,long rollNumber){
        for(Book book : new Student(rollNumber).getListOfBooksIssued())
            if(book.getISBNNumberOfBook() == ISBNNumber) {
                book.setAvailability((byte) 1);
                return true;
            }
        return false;
    }



    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj)
            return false;
        Library library = (Library) obj;
        return Arrays.equals(getBooksAvailableInTheLibrary(), library.getBooksAvailableInTheLibrary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBooksAvailableInTheLibrary());
    }
}
