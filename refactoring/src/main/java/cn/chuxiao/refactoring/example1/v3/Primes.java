package cn.chuxiao.refactoring.example1.v3;

import java.util.Arrays;

//编写一个函数，返回小于给定最大值max的所有素数组成的数组
public class Primes {


    public static int[] getPrimes(int max) {

        if (max < 2) {
            return new int[]{};
        }
        int[] primes = new int[max];

        //提取函数，代码的意图更加清晰，同时去除了j
        int count = 0;
        for (int num = 2; num < max; num++) {
            if (isPrime(num)) {
                primes[count++] = num;
            }
        }
        primes = Arrays.copyOf(primes, count);

        return primes;
    }

    //isPrime函数看起来还是不舒服
    private static boolean isPrime(int num) {
        int j = 0;
        for (j = 2; j < num / 2; j++) {
            if (num % j == 0) {
                break;
            }
        }
        if (j == num / 2 + 1) {
            return true;
        }

        return false;
    }
}
