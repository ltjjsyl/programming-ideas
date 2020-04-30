package cn.chuxiao.refactoring.example1.v5;

import java.util.Arrays;

//编写一个函数，返回小于给定最大值max的所有素数组成的数组
//意想不到的好处：
//getPrimes方法负责高层策略，不用陷入细节
//isPrime方法职责单一，可以替换，易测试，潜在的复用
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

        return Arrays.copyOf(primes, count);
    }

    private static boolean isPrime(int num) {

        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
