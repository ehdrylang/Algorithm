package com.tistory.jeongpro.study.week10;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;

/**
 * 교환 주어진 수와 변경 횟수를 가지고 최대값으로 만들 수 있는 수를 출력하라
 */
public class Trading {
    private static char[] sentence;
    private static char[] best;

    /**
     * @param source 1,000,000 이하 자연수
     * @param k      10이하 자연수
     */
    public static int solution(String source, int k) {
        sentence = source.toCharArray();
        StringBuilder sb2 = new StringBuilder();

        for(int i=sentence.length-1;i>=0;i--) {
            sb2.append(sentence[i]);
        }
        sentence = sb2.toString().toCharArray();
        best = source.toCharArray();
        Arrays.sort(best); // 가장 큰 수
        if (sentence.length <= 1) { // 예외 처리
            return -1;
        }
        for (int i = 0; i < k; i++) {
            // 어디까지 최적이랑 유사한가?
            int sortedIndex = getSortedIndex(sentence, best);
            if (sortedIndex == -1) { // 이미 최대값인 상태이라면?
                swap(0, 1);
            } else {
                int maxIndex = getMaxIndex(0, sortedIndex);
                swap(maxIndex, sortedIndex);
            }
            if (isZeroAtFirst()) {
                return -1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = sentence.length-1; i >= 0; --i) {
            sb.append(sentence[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    private static int getMaxIndex(int start, int end) {
        int max = -1;
        int maxIdx = -1;
        for (int i = start; i <= end; i++) {
            int value = sentence[i] - '0';
            if (max < value) {
                max = value;
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private static void swap(int idx1, int idx2) {
        char temp = sentence[idx1];
        sentence[idx1] = sentence[idx2];
        sentence[idx2] = temp;
    }


    public static boolean isZeroAtFirst() {
        return sentence[sentence.length - 1] == 0;
    }

    public static int getSortedIndex(char[] source, char[] target) {
        for (int i = target.length - 1; i >= 0; i--) {
            if (target[i] != source[i]) {
                return i;
            }
        }
        return -1;
    }
}
