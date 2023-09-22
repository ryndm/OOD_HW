package edu.syr.hw2;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList = new ArrayList<>();

    public void add(Book b) {
        this.bookList.add(b);
    }

    public List<Book> getList() {
        return this.bookList;
    }

    public List<Book> search(Book searchBook) {
        List<Book> result = new ArrayList<>();

        for (Book b : bookList) {
            if(b.matches(searchBook)) {
                result.add(b);
            }
        }
        return result;
    }

}
