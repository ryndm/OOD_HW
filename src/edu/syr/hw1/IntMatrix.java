package edu.syr.hw1;

import java.util.Arrays;

public class IntMatrix {
    private int[] data;
    private int rows;
    private int cols;

    public IntMatrix(int r, int c) {
        //TODO
        if(r <= 0)
            throw new UnsupportedOperationException("Rows should be greater than 0.");
        else if(c <= 0)
            throw new UnsupportedOperationException("Columns should be greater than 0.");
        else {
            this.rows = r;
            this.cols = c;
            this.data = new int[r * c];
        }
    }
    public int get(int r, int c) {
        //TODO
        if(r >= 0 && r < this.rows && c >= 0 && c < cols) {
            return this.data[r * this.cols + c];
        } else {
            throw new UnsupportedOperationException("Invalid cell");
        }
    }

    public void set(int r, int c, int val) {
        //TODO
        if(r >= 0 && r < rows && c >= 0 && c < cols) {
            this.data[r * cols + c] = val;
        } else {
            throw new UnsupportedOperationException("Invalid cell");
        }
    }

    public void initialize(int val) {
        //TODO
        Arrays.fill(this.data, val);
    }
}

