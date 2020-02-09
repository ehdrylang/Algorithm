package com.tistory.jeongpro.algorithm;

import java.util.Scanner;

/**
 * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 *
 * 아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.
 *
 *
 *
 * 입력
 * 첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
 *
 * 출력
 * 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 *
 * 풀이방법
 * 1부터 점화식을 찾아보자.
 */
public class tile {
    private static int[] results = new int[1001];
    public static int 경우의수(){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()); // 2*n
        //1
        results[0] = 0;
        results[1] = 1;
        results[2] = 2;
        for(int i=3;i<=n;i++){
            results[i] = results[i-1] + results[i-2];
        }
    /*import java.util.Scanner;
public class Main{
    private static int[] results = new int[1001];
    public static void main(String[] args){
        results[0]=0;
        results[1]=1;
        results[2]=2;
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i=3;i<1001;i++){
            results[i] = results[i-1] + results[i-2];
        }
        System.out.print(results[n]%10007);
    }
}*/

        return n;
    }
}
