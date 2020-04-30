package cn.chuxiao.refactoring.example1.v4;

import java.util.Arrays;

//编写一个函数，返回小于给定最大值max的所有素数组成的数组
public class Primes {

    public static int[] getPrimes(int max) {

        if (max < 2) {
            return new int[]{};
        }
        int[] primes = new int[max];

        int count = 0;
        for (int num = 2; num < max; num++) {
            if (isPrime(num)) {
                primes[count++] = num;
            }
        }

        //可以直接返回，更加清爽
        return Arrays.copyOf(primes, count);
    }

    //j -> i i更常见
    //去掉break,直接return
    private static boolean isPrime(int num) {

        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
