package edu.syr.hw2;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b2 = new Book("Norman Matloff", "The Art of R Programming", "No Starch Press", "9781593273842", 2011);
        Book b3 = new Book("Alan A. A. Donovan", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016);
        Book b4 = new Book("", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016);

        Library lb = new Library();

        lb.add(b1);
        lb.add(b2);
        lb.add(b3);

        Book toFind = new Book("", "The", "", "", 2011);

        List<Book> searchResult = lb.search(toFind);

        for(Book b: searchResult) {
            System.out.println(b.toString());
        }

        System.out.println(b3.equals(b4));
    }
}
