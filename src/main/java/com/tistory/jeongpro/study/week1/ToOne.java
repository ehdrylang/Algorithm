package com.tistory.jeongpro.study.week1;

/**
 * 1이 될 때까지
 */
public class ToOne {
    public static int test(int n, int k) {
        int count = 0;
        while(n != 1) {
            if (n % k == 0) {
                n /= k;
            } else {
                n -= 1;
            }
            count++;
        }
        return count;
    }
}
