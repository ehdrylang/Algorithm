package com.tistory.jeongpro.algorithm;

/**
 * 문제
 * 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
 *
 * 1+1+1+1
 * 1+1+2
 * 1+2+1
 * 2+1+1
 * 2+2
 * 1+3
 * 3+1
 * 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.
 *
 * 출력
 * 각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.
 *
 * 풀이 방법
 *  점화식이 굉장히 어렵게 생각할 수 있다. (생각도 못했음)
 */
public class AddOneTwoThree {
    private static int[] results;
    static {
        results = new int[12]; // max 11이라고 문제에서 정의했음.
        results[0] = 0;
        results[1] = 1;
        results[2] = 2;
        results[3] = 4;
    }
    public static int addOneTwoThree(int n){
        if(results[n] > 0){
            return results[n];
        }
        return results[n] = addOneTwoThree(n - 1) + addOneTwoThree(n - 2) + addOneTwoThree(n - 3);
    }
}
