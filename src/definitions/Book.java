/*  Created by IntelliJ IDEA.
 *  User: Divyansh Bhardwaj (dbc2201)
 *  Date: 21/08/20
 *  Time: 3:49 PM
 *  File Name : Book.java
 * */
package definitions;

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
}
