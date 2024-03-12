package edu.syr.hw2;

import java.util.Arrays;

public final class Q4 {
    private final char[] data;

    public Q4(char[] d) {
         data = new char[d.length];
         for (int i = 0; i < data.length;i++){
             data[i] = d[i];
         }
    }

    public char[] getData() {
        return Arrays.copyOf(data, data.length);
    }

    public static void main(String[] args) {
        char[] d = {'a', 'b'};
        Q4 test = new Q4(d);
        System.out.println(test.getData());

        char[] e = test.getData();

        e[0] = 'c';
        System.out.println(test.getData());
    }

}
