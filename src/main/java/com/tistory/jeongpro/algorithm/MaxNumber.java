package com.tistory.jeongpro.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래머스 가장 큰수
 */
public class MaxNumber {
    public String solution(int[] numbers) {
        String answer = "";

        List<String> stringList = new ArrayList<>();

        for (int anInt : numbers)
            stringList.add(String.valueOf(anInt));

        stringList.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        for (String s : stringList) {
            answer += s;
        }

        return answer.charAt(0) == '0' ? "0" : answer;
    }
}
