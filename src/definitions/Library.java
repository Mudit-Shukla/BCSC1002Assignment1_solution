/*  Created by IntelliJ IDEA.
 *  User: Divyansh Bhardwaj (dbc2201)
 *  Date: 21/08/20
 *  Time: 3:50 PM
 *  File Name : Library.java
 * */
package definitions;

import java.util.Arrays;

public class Library {
    private Book[] booksAvailableInTheLibrary;

    public Library(Book[] booksAvailableInTheLibrary) {
        this.booksAvailableInTheLibrary = booksAvailableInTheLibrary;
    }

    public Book[] getBooksAvailableInTheLibrary() {
        return booksAvailableInTheLibrary;
    }

    public void setBooksAvailableInTheLibrary(Book[] booksAvailableInTheLibrary) {
        this.booksAvailableInTheLibrary = booksAvailableInTheLibrary;
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
}
