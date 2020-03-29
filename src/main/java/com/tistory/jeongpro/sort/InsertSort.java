package com.tistory.jeongpro.sort;

/**
 * 이미 정렬된 것에
 */
public class InsertSort {
    public static int[] numbers = {4,3,2,7,6,5,1,10,9,8};

    public static int[] insertSort(){
        for(int i=0;i<numbers.length-1;i++){
            int j=i;
            while(j>=0 && numbers[j] > numbers[j+1]){
                swap(numbers, j, j+1);
                j--;
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
