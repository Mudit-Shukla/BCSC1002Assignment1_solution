/*  Created by IntelliJ IDEA.
 *  User: Divyansh Bhardwaj (dbc2201)
 *  Date: 21/08/20
 *  Time: 3:49 PM
 *  File Name : Student.java
 * */
package definitions;

public class Student {
    private String firstName;
    private String middleName;
    private String lastName;
    private long rollNumber;
    private int numberOfBooksIssued;
    private Book[] listOfBooksIssued;

    public Student(String firstName, String middleName, String lastName, long rollNumber, int numberOfBooksIssued, Book[] listOfBooksIssued) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.rollNumber = rollNumber;
        this.numberOfBooksIssued = numberOfBooksIssued;
        this.listOfBooksIssued = listOfBooksIssued;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(long rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getNumberOfBooksIssued() {
        return numberOfBooksIssued;
    }

    public void setNumberOfBooksIssued(int numberOfBooksIssued) {
        this.numberOfBooksIssued = numberOfBooksIssued;
    }

    public Book[] getListOfBooksIssued() {
        return listOfBooksIssued;
    }

    public void setListOfBooksIssued(Book[] listOfBooksIssued) {
        this.listOfBooksIssued = listOfBooksIssued;
    }

}
