package edu.syr.hw2;

import java.util.ArrayList;
import java.util.List;


public class CaseInsensitiveString {
    List<String> data;

    enum TEST {
        TEST,
        DONE
    }
    public CaseInsensitiveString() {
        data = new ArrayList<>();
    }
    public void remember(String s) {
        if(s != null) {
            this.data.add(s);
        }
    }
    public String recall(String s) {
        if(s != null) {
            for (String line: data) {
                if(line.indexOf(s) != -1) {
                    return line;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        CaseInsensitiveString caseInsensitiveString = new CaseInsensitiveString();
        TEST a = TEST.DONE;
    }

}
