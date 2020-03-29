package com.tistory.jeongpro.sort;

/**
 * 제일 작은거를 앞으로 옮기자
 */
public class SelectionSort {
    public static int[] numbers = {4,3,2,7,6,5,1,10,9,8};

    public static int[] selectionSort(){
        for(int i=0;i<numbers.length;i++){
            int min = Integer.MAX_VALUE;
            int idx = i;
            for(int j=i;j<numbers.length;j++){
                if(min > numbers[j]){
                    min = numbers[j];
                    idx = j;
                }
            }
            swap(numbers, i, idx);
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
