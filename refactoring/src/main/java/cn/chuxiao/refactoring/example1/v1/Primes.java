package cn.chuxiao.refactoring.example1.v1;

import java.util.Arrays;

//编写一个函数，返回小于给定最大值max的所有素数组成的数组
public class Primes {

    //函数看起来很复杂，非常多的细节！
    //i,j..让人眼花缭乱
    public static int[] getPrimes(int max) {

        int[] newArray = new int[]{};

        if (max > 2) {
            newArray = new int[max];
            int size = 0, j = 0;
            for (int i = 2; i < max; i++) {
                for (j = 2; j < i / 2; j++) {
                    if (i % j == 0) {
                        break;
                    }
                }
                if (j == i / 2 + 1) {
                    newArray[size++] = i;
                }
            }
            newArray = Arrays.copyOf(newArray, size);
        }

        return newArray;
    }
}
