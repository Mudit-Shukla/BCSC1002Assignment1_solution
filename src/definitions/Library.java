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

    public Library(Book[] booksAvailableInTheLibrary) {
        this.booksAvailableInTheLibrary = booksAvailableInTheLibrary;
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
       if(getBooksAvailableInTheLibrary() == null)
           return false;
        else{
            for(Book book : booksAvailableInTheLibrary)
            if(book.getISBNNumberOfBook().equals(ISBNNumber))
                if(book.getAvailability() == 1) {
                    book.setAvailability((byte) 0);
                    return true;
                }
        }
        return false;
    }

    public void addBookToTheLibrary(String nameOfBook, String nameOfAuthor, String ISBNCode){
        System.out.println("New book added to list of the books available in library");
    }

    public boolean removeBookFromLibrary(String nameOfBook, String nameOfAuthor, String ISBNCode) {
        if(booksAvailableInTheLibrary == null) {
            System.out.println("No such book is available in the library");
            return false;
        }
        for(Book book : booksAvailableInTheLibrary)
            if(book.equals(new Book(nameOfBook,nameOfAuthor,ISBNCode,(byte)1))){
               book.setAvailability((byte) 0);
               System.out.println("Book removed from the list of the available books in the library");
               return true;
        }
        return false;
    }

    public boolean returnIssuedBook(String nameOfBook, String ISBNNumber,long rollNumber){
        Student student = new Student(rollNumber);
        if(student.getListOfBooksIssued() == null)
            return false;
        else{
            for(Book book : student.getListOfBooksIssued())
            if(book.getISBNNumberOfBook().equals(ISBNNumber)) {
                book.setAvailability((byte) 1);
                return true;
            }
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
