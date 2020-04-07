package com.tistory.jeongpro.algorithm;

/**
 * 에라토스테네스의 체 (1부터 범위 내에있는 소수 값을 판별하기)
 */
public class Eratostenes {

    public void eratostenes(int n){
        int[] ranges = new int[n+1];
        //모든 숫자 준비
        //1은 소수가 아니므로 2부터 넣는 것으로 했음
        for(int i=2;i<ranges.length;i++){
            ranges[i] = i;
        }
        //자기 자신을 제외한 배수 지우기
        for(int i=2;i<ranges.length;i++){
            if(ranges[i] == 0) {
                continue;
            }
            for(int j=i+i;j<ranges.length;j+=i){
                ranges[j] = 0;
            }
        }
        for(int i=2;i<ranges.length;i++){
            if(ranges[i] != 0){
                System.out.println(ranges[i]);
            }
        }
    }
}
