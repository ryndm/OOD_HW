package edu.syr.hw1;

import java.util.List;

public class Library {
    private List<String> bookList;

    public void init(List<String> bookList) {
        this.bookList = bookList;
    }

    public String search(String searchTerm) {
        for (String s : bookList) {
            // Using the built-in function to return the first most likely string.
            if(s.toLowerCase().contains(searchTerm.toLowerCase())) {
                return s;
            }
        }
        return "Not Found!!";
    }

}
