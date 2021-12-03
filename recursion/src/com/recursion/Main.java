package com.recursion;

/**
 * Created by marathoner on 2021/12/03
 */
public class Main {
    public static void main(String[] args) {
        int result = sumOfKFromOne(4);
        System.out.println("Sum Result : " + result);
        System.out.println("==================================");

        result = factorial(4);
        System.out.println("Factorial Result : " + result);
        System.out.println("==================================");

        result = fibonacci(4);
        System.out.println("Fibonacci Result : " + result);
        System.out.println("==================================");

        result = euclid(4, 3);
        System.out.println("Euclid Result : " + result);
        System.out.println("==================================");

    }

    public static int sumOfKFromOne(int k) {
        if (k <= 0) return 0;
        return k + sumOfKFromOne(k - 1);
    }

    public static int factorial(int k) {
        if (k == 0) return 1;
        return k * factorial(k - 1);
    }

    public static int fibonacci(int k) {
        if (k < 2) return k;
        return fibonacci(k - 1) + fibonacci(k - 2);
    }

    public static int euclid(int m, int n) {
        if (n == 0) return m;
        return euclid(n, m % n);
    }
}
