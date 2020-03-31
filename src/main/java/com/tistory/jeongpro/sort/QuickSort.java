package com.tistory.jeongpro.sort;

/**
 * 피벗을 기준으로 왼쪽부터 큰것을 찾고 오른쪽부터는 작은 것을 찾아서 교환해준다
 */
public class QuickSort {
    public static int[] numbers = {4,3,2,7,6,5,1,10,9,8};

    public static void swap(int[] array, int idx1, int idx2){
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }
    public static void quickSort(){
        quickSort(numbers, 0, numbers.length-1);

        for(int a : numbers){
            System.out.println(a);
        }
    }
    public static void quickSort(int[] array, int left, int right){
        if(left < right){
            int pivot = partition(array, left, right);
            quickSort(array, left , pivot-1);
            quickSort(array, pivot+1, right);
        }
    }
    public static int partition(int[] array, int left, int right){
        int pivot = array[left];//피벗
        int i = left;//시작
        int j = right;//끝
        while(i < j){ //겹쳐질때까지 계속
            while(i < j && array[i] < pivot){
                i++;
            }
            while(i < j && array[j] > pivot){
                j--;
            }
            if(i < j){
                swap(array, i, j);
            }
        }
        return i;
    }
}
