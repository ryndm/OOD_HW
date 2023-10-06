// rdmello
package edu.syr.hw5;

import java.util.HashMap;
import java.util.Map;

public class Rational {
    private int numer;
    private int denom;
    private int g;

    private static final Map<String, Rational> CACHE = new HashMap<>();


    private Rational(int n, int d) {
        numer = n;
        denom = d;
    }


    public static Rational getInstance(int n, int d) {
        if (d == 0) {
            throw new IllegalArgumentException("Denominator can't be 0!");
        }
        int g = gcd(n, d);
        int reducedN = n / g;
        int reducedD = d / g;

        String cacheKey = reducedN + "/" + reducedD;

        if (!CACHE.containsKey(cacheKey)) {
            CACHE.put(cacheKey, new Rational(reducedN, reducedD));
        }
        return CACHE.get(cacheKey);
    }

    public static Rational getInstance(int n) {
        return getInstance(n, 1);
    }

    private static int gcd(int n, int d) {
        return d==0 ? n : gcd(d, n%d);
    }

    @Override
    public String toString() {
        return denom==1 ? numer +"" : numer + "/" + denom;
    }

    public Rational add(Rational that) {
        return getInstance(numer * that.denom + denom * that.numer, denom * that.denom);
    }

    public Rational add(int that) {
        return add(getInstance(that));
    }

    public boolean lessThan(Rational that) {
        return this.numer * that.denom < that.numer * this.denom;
    }

    public boolean lessThan(int that) {
        return lessThan(getInstance(that));
    }

    public Rational max(Rational that) {
        return this.lessThan(that) ? that : this;
    }

    public Rational max(int that) {
        return max(getInstance(that));
    }

    public static void main(String[] args) {
        Rational half = Rational.getInstance(1, 2);
        Rational third = Rational.getInstance(1, 3);
        System.out.println(half.max(third)); // returns half; prints "1/2"
        System.out.println(third.max(half)); // returns half; prints "1/2"
        Rational result = half.add(third);
        Rational fiveSixths = Rational.getInstance(5, 6);
        System.out.println("are they the same object? " + (result == fiveSixths));
        System.out.println(fiveSixths.lessThan(result)); // false
        System.out.println(result.lessThan(fiveSixths)); // false
        Rational one = Rational.getInstance(1);
        Rational oneAndHalf = one.add(half);
        System.out.println(oneAndHalf); // prints "3/2";
        Rational fifteenOverTen = Rational.getInstance(15, 10);
        System.out.println(fifteenOverTen); // prints "3/2"
    }
}
