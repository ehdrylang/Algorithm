package com.tistory.jeongpro.study.week1;

/**
 * 큰 수의 법칙
 */
public class LawOfLargeNumbers {
    /**
     * @param n     : 배열의 크기
     * @param m     : 숫자가 더해지는 횟수
     * @param k     : 동일 인덱스 최대 선택 횟수
     * @param array : 배열
     */
    public static int test(int n, int m, int k, int[] array) {
        // 배열에서 가장 큰 수와 그 다음 큰 수만 있으면 됨.
        int max1 = bubbleOneCycle(array, array.length);
        int max2 = bubbleOneCycle(array, array.length - 1);
        //
        int count = 0;
        int result = 0;
//        for (int i = 0; i < m; i++) {
//            if (count == k) {
//                result += max2;
//                count = 0;
//            } else {
//                result += max1;
//                count++;
//            }
//        }
        int cycle = m / (k + 1);
        int remain = m % (k + 1);
        return cycle * (k * max1 + max2) + remain * max1;
    }

    private static int bubbleOneCycle(int[] array, int size) {
        for (int i = 0; i < size - 1; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        return array[size - 1];
    }
}
