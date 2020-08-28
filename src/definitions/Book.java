/*  Created by IntelliJ IDEA.
 *  User: Divyansh Bhardwaj (dbc2201)
 *  Date: 21/08/20
 *  Time: 3:49 PM
 *  File Name : Book.java
 * */
package definitions;

import java.util.Arrays;
import java.util.Objects;

public class Book {
    private String nameOfBook;
    private String nameOfTheAuthorOfBook;
    private String ISBNNumberOfBook;

    public Book(String nameOfBook, String nameOfTheAuthorOfBook, String ISBNNumberOfBook) {
        this.nameOfBook = nameOfBook;
        this.nameOfTheAuthorOfBook = nameOfTheAuthorOfBook;
        this.ISBNNumberOfBook = ISBNNumberOfBook;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getNameOfTheAuthorOfBook() {
        return nameOfTheAuthorOfBook;
    }

    public void setNameOfTheAuthorOfBook(String nameOfTheAuthorOfBook) {
        this.nameOfTheAuthorOfBook = nameOfTheAuthorOfBook;
    }

    public String getISBNNumberOfBook() {
        return ISBNNumberOfBook;
    }

    public void setISBNNumberOfBook(String ISBNNumberOfBook) {
        this.ISBNNumberOfBook = ISBNNumberOfBook;
    }



    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj)
            return false;
        Book book = (Book) obj;
        return Objects.equals(getNameOfBook(), book.getNameOfBook()) &&
                Objects.equals(getNameOfTheAuthorOfBook(), book.getNameOfTheAuthorOfBook()) &&
                Objects.equals(getISBNNumberOfBook(), book.getISBNNumberOfBook());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameOfBook(), getNameOfTheAuthorOfBook(), getISBNNumberOfBook());
    }
}
