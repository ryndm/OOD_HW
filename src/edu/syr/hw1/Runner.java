package edu.syr.hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        IntMatrix i = new IntMatrix(2,3);
        i.set(1,2, 21);
        System.out.println(i.get(1,2));
    }
}