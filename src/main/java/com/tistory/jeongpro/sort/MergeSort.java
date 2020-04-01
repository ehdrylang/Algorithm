package com.tistory.jeongpro.sort;

/**
 * 머지소트 일단 반으로 나누고 정렬해보자
 */
public class MergeSort {
    public static int[] numbers = {4,3,2,7,6,5,1,10,9,8};
    public static int[] result = new int[numbers.length];

    public static void swap(int[] array, int idx1, int idx2){
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static void mergeSort(int[] array, int start, int end){
        if(start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle+1, end);
            merge(array, start, middle, end);
        }
        for (int v : numbers) {
            System.out.println(v);
        }
    }
    public static void merge(int[] array, int start, int middle, int end){
        int i = start;
        int j = middle + 1;
        int k = start;

        while(i <= middle && j <= end){
            if(array[i] <= array[j]){
                result[k] = array[i];
                i++;
            }else{
                result[k] = array[j];
                j++
            }
            k++;
        }
        //
        if(i > middle){
            for(int t = j; t < end; t++){
                result[k] = array[t];
                k++;
            }
        }else{
            for(int t = i;t < middle; t++){
                result[k] = array[t];
                k++;
            }
        }
        for(int t=start;t<end;t++){
            numbers[t] = result[t];
        }
    }
}
