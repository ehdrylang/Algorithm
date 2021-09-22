package com.tistory.jeongpro.study.week1;

/**
 * 숫자 카드 게임
 */
public class CardGame {
    public static int test(int[][] array) {
        int[] mins = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            mins[i] = min(array[i]);
        }
        return max(mins);
    }
    private static int min(int[] array) {
        int result = Integer.MAX_VALUE;
        for(int value : array) {
            if(result > value) {
                result = value;
            }
        }
        return result;
    }
    private static int max(int[] array) {
        int result = Integer.MIN_VALUE;
        for(int value : array) {
            if(result < value) {
                result = value;
            }
        }
        return result;
    }
}
