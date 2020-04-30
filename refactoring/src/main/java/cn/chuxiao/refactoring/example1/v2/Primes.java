package cn.chuxiao.refactoring.example1.v2;

import java.util.Arrays;

//编写一个函数，返回小于给定最大值max的所有素数组成的数组
public class Primes {

    public static int[] getPrimes(int max) {

        //先处理边界
        //把newArray的定义下移
        if (max < 2) {
            return new int[]{};
        }
        //newArray - > primes
        int[] primes = new int[max];

        //size -> count   i -> num
        int count = 0, j = 0;
        for (int num = 2; num < max; num++) {
            for (j = 2; j < num / 2; j++) {
                if (num % j == 0) {
                    break;
                }
            }
            if (j == num / 2 + 1) {
                primes[count++] = num;
            }
        }
        primes = Arrays.copyOf(primes, count);

        return primes;
    }
}
