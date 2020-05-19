package com.tistory.jeongpro.greedy;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * 문제 설명
 * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
 *
 * 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
 *
 * 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
 *
 * 제한 조건
 * number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
 * k는 1 이상 number의 자릿수 미만인 자연수입니다.
 * 입출력 예
 * number	    k	return
 * 1924 	    2	94
 * 1231234	    3	3234
 * 4177252841	4	775841
 * 출처
 */
@Component
public class BigInteger {
    @PostConstruct
    private void test(){
        String str = "1231234";
        System.out.println("what : "  + solution(str, 3));
    }
    public String solution(String number, int k) {
        int size = number.length() - k; //최종 결과의 자릿수
        char[] numbers = number.toCharArray();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = k;
        for(int i=0;i<size;i++){
            int maxIdx = maxIndex(start, end, numbers);
            sb.append(numbers[maxIdx]);
            start = ++maxIdx;
            end++;
        }
        return sb.toString();
    }
    private int maxIndex(int startIdx, int endIdx, char[] array){
        int max = -1;
        int idx = -1;
        for(int i=startIdx;i<=endIdx;i++){
            if(array[i] > max){
                max = array[i];
                idx = i;
            }
        }
        return idx;
    }
}
