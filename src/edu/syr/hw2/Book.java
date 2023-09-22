package edu.syr.hw2;

import java.util.Objects;

public class Book {
    private String author;
    private String title;
    private String publisher;
    private String isbn;
    private int yearPublished;

    public Book(String a, String t, String p, String i, int y) {
        this.author = a==null ? "" : a;
        this.title = t==null ? "" : t;
        this.publisher = p==null ? "" : p;
        this.isbn = i==null ? "" : i;
        this.yearPublished = y;
    }

    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getIsbn() {
        return isbn;
    }
    public int getYearPublished() {
        return yearPublished;
    }

    public boolean matches(Book b) {
        if (!author.equals("") && !author.toLowerCase().contains(b.author.toLowerCase())) {
            return false;
        }
        if (!title.equals("") && !title.toLowerCase().contains(b.title.toLowerCase())) {
            return false;
        }
        if (!publisher.equals("") && !publisher.toLowerCase().contains(b.publisher.toLowerCase())) {
            return false;
        }
        if (!isbn.equals("") && ! b.isbn.equals("") && !isbn.equals(b.isbn)) {
            return false;
        }
        if (yearPublished > 1700 && b.yearPublished> 1700 && yearPublished != b.yearPublished) {
            return false;
        }
        return true;
    }


    /*
     *******************  Question 2  ***********************
     */

    @Override
    public int hashCode() {
        /*
            As ISBN of a book is always unique, it should be enough to be used as a hashCode.
            To make it look like a hashCode we could do something like below
                return Objects.hash(isbn);
            But since we are allowing the book class to have empty isbn fields, I am using all the fields of the book
            for generating the hashCode of a particular book.
            I am aware that below method is going to cause problems when the books are same but maybe one of them has
            a missing field. In this case, the hashCodes will be different for the same(duplicate copy) book.
            However, I think that is out of scope for this assignment.
         */
        return Objects.hash(author, title, publisher, isbn, yearPublished);
    }

    @Override
    public boolean equals(Object obj) {
        /*
            I have compared the hashCode for checking the equality. Here, I had the choice of making the equality test
            case insensitive. And I think because of this method being used only for the Book class, it should be
            case insensitive. However, I have made it case sensitive. That's just because I wanted it to be strictly equal.
         */
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Book b = (Book) obj;
        return this.hashCode() == b.hashCode();
    }

    @Override
    public String toString() {
        return "Author: " + (author != null ? author : "")
                + ", Title: " + (title != null ? title : "")
                + ", Publisher: " + (publisher != null ? publisher : "")
                + ", ISBN: " + (isbn != null ? isbn : "")
                + ", Year: " + (yearPublished > 1700 ? yearPublished : "");
    }


    public static void main(String[] args) {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b2 = new Book("Norman Matloff", "The Art of R Programming", "No Starch Press", "9781593273842", 2011);
        Book b3 = new Book("Alan A. A. Donovan", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016);
    }
}
