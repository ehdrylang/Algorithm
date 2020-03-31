package com.tistory.jeongpro.sort;

/**
 * 바로 옆에 것과 비교를 해보자
 *
 * j를 감소시키는 for문 작성을 못했다
 */
public class BubbleSort {
    public static int[] numbers = {4,3,2,7,6,5,1,10,9,8};

    public static int[] bubbleSort(){

        for(int i=numbers.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(numbers[j] > numbers[j+1]){
                    swap(numbers, j , j+1);
                }
            }
        }
        for(int v : numbers){
            System.out.println(v);
        }
        return numbers;

    }

    public static void swap(int[] array, int idx1, int idx2){
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }
}
