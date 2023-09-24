// rdmello
package edu.syr.hw4;

/* Adapted from Programming in Scala, Odersky */

public class Rational {
    private int numer;
    private int denom;
    private int g;
    public Rational(int n, int d) { /*implement this*/
        this.g = this.calculateGCD(n, d);
        this.numer = n/this.g;
        this.denom = d/this.g;
    }

    public Rational(int n) {/*implement this*/
        this(n, 1);
    }

    private int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    @Override
    public String toString() {/*implement this*/
        return this.numer + "/" + this.denom;
    }

    public Rational add(Rational that) {/*implement this*/
        int newNumer = this.numer * that.denom + that.numer * this.denom;
        int newDenom = this.denom * that.denom;
        int newGcd = calculateGCD(newNumer, newDenom);
        return new Rational(newNumer / newGcd, newDenom / newGcd);
    }

    public Rational add(int that) {/*implement this*/
        return this.add(new Rational(that));
    }

    public boolean lessThan(Rational that) {/*implement this*/
        return this.numer * that.denom < that.numer * this.denom;
    }

    public boolean lessThan(int that) {/*implement this*/
        return this.lessThan(new Rational(that));
    }

    public Rational max(Rational that) {/*implement this*/
        return this.lessThan(that) ? that : this;
    }

    public Rational max(int that) {/*implement this*/
        return this.max(new Rational(that));
    }

    public static void main(String[] args) {
        Rational half = new Rational(1, 2);
        Rational third = new Rational(1, 3);
        System.out.println(half.max(third)); // returns half; prints "1/2"
        System.out.println(third.max(half)); // returns half; prints "1/2"
        Rational result = half.add(third);
        Rational fiveSixths = new Rational(5, 6);
        System.out.println("are they the same object? " + (result == fiveSixths));
        System.out.println(fiveSixths.lessThan(result)); // false
        System.out.println(result.lessThan(fiveSixths)); // false
        Rational one = new Rational(1);
        Rational oneAndHalf = one.add(half);
        System.out.println(oneAndHalf); // prints "3/2";
        Rational fifteenOverTen = new Rational(15, 10);
        System.out.println(fifteenOverTen); // prints "3/2"
    }
}
