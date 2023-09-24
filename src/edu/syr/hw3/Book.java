// rdmello
package edu.syr.hw3;

import java.util.Objects;

public class Book {
    private String author;
    private String title;
    private String publisher;
    private String isbn;
    private int yearPublished;
    private BookType type;

    public Book(String a, String t, String p, String i, int y, BookType b) {
        this.author = a;
        this.title = t;
        this.publisher = p;
        this.isbn = i;
        this.yearPublished = y;
        this.type = b;
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
    public BookType getType() {
        return type;
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
        return Objects.hash(author, title, publisher, isbn, yearPublished, type);
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
        if (author != null && b.getAuthor() != null) {
            if (!author.equalsIgnoreCase(b.getAuthor())) return false;
        } else if (author != b.getAuthor()) return false;

        if (title != null && b.getTitle() != null) {
            if(!title.equalsIgnoreCase(b.getTitle())) return false;
        } else if(title != b.getTitle()) return false;

        if (publisher != null && b.getPublisher() != null) {
            if (!publisher.equalsIgnoreCase(b.getPublisher())) return false;
        } else if(publisher != b.getPublisher()) return false;

        if (isbn != null && b.getIsbn() != null) {
            if (!isbn.equalsIgnoreCase(b.getIsbn())) return false;
        } else if(isbn != b.getIsbn()) return false;

        if (yearPublished != b.yearPublished) return false;

        return type == b.type;
    }

    @Override
    public String toString() {
        return "Author: " + (author != null ? author : "")
                + ", Title: " + (title != null ? title : "")
                + ", Publisher: " + (publisher != null ? publisher : "")
                + ", ISBN: " + (isbn != null ? isbn : "")
                + ", Year: " + (yearPublished > 1700 ? yearPublished : "")
                + ", Type: " + type;
    }


    public static void main(String[] args) {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.HARDCOVER);
        Book b2 = new Book("Norman Matloff", "The Art of R Programming", "No Starch Press", "9781593273842", 2011, BookType.PAPERBACK);
        Book b3 = new Book("Alan A. A. Donovan", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016, BookType.ANY);
    }
}
