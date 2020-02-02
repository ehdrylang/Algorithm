package com.tistory.jeongpro.algorithm;

/**
 * 문제 : 1로 만들기
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 *
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 *
 * 입력
 * 첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
 *
 * 출력
 * 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 *
 * 문제 해결 방법
 * 문제를 해결하는 메서드를 toOne로 두었을 때, bottom up 방식으로 계산하고 동적계획법에 의한 순환식을 찾는다.
 */
public class ToOne {
    private static int[] results = new int[1000001];

    static {
        results[0] = 0;
        results[1] = 0;
        results[2] = 1; // 2로 나누면 1
        results[3] = 1; // 3으로 나누면 1
        for(int i=4;i<=1000000;i++){
            int[] temp = {Integer.MAX_VALUE ,Integer.MAX_VALUE ,Integer.MAX_VALUE};
            if(i%2 == 0){
                temp[1] = results[i/2];
            }
            if(i%3 == 0){
                temp[2] = results[i/3];
            }
            temp[0] = results[i-1];
            results[i] = 1 + Integer.min(Integer.min(temp[0], temp[1]), temp[2]);
        }
    }

    public static int calc(int n){
        //제약조건 처리
        if(n < 1 || n > 1000000){
            return 0;
        }
        return results[n];
    }
}
