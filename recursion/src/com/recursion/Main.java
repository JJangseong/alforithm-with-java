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

        result = length("hello");
        System.out.println("Length Result : " + result);
        System.out.println("==================================");

        printChars("hello");
        System.out.println("==================================");

        printCharsReverse("hello");
        System.out.println("==================================");

        printInBinary(5);
        System.out.println("");
        System.out.println("==================================");

        int[] a = {4, 3, 2, 1};
        result = sumByArray(a.length-1, a);
        System.out.println("SumByArray Result : " + result);
        System.out.println("==================================");

    }

    // 1 부터 K 까지의 합
    public static int sumOfKFromOne(int k) {
        if (k <= 0) return 0;
        return k + sumOfKFromOne(k - 1);
    }

    // 팩토리오
    public static int factorial(int k) {
        if (k == 0) return 1;
        return k * factorial(k - 1);
    }

    // 피보나치수열
    public static int fibonacci(int k) {
        if (k < 2) return k;
        return fibonacci(k - 1) + fibonacci(k - 2);
    }

    // 최대 공약수
    public static int euclid(int m, int n) {
        if (n == 0) return m;
        return euclid(n, m % n);
    }

    // 문자열 길이 계산
    public static int length(String str) {
        if (str.equals("")) return 0;
        return 1 + length(str.substring(1));
    }

    // 문자열 출력
    public static void printChars(String str) {
        if (str.length() == 0) return;
        System.out.println(str.charAt(0));
        printChars(str.substring(1));
    }

    // 문자열 반대로 출력
    public static void printCharsReverse(String str) {
        if (str.length() == 0) return;
        printCharsReverse(str.substring(1));
        System.out.println(str.charAt(0));
    }

    public static void printInBinary(int k) {
        if (k < 2) {
            System.out.print(k);
            return;
        }
        printInBinary(k / 2);
        System.out.print(k % 2);
    }

    public static int sumByArray(int index, int[] k) {
        if (index == -1) return 0;
        return sumByArray(index - 1, k) + k[index];
    }

    public static int search(int[] data, int n , int target) {
        for(int i=0; i<n; i++)
            if(data[i] == target)
                return i;

        return -1;
    }

}
