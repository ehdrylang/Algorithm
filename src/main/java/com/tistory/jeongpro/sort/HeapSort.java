package com.tistory.jeongpro.sort;

/**
 * 힙정렬
 * 완전이진트리로 만들어서 최대힙 또는 최소힙을 구현하고
 * 최대힙일 때 루트노드는 최대값이니까 제일 마지막 노드랑 교환하고
 * 방금 바꾼 노드는 정렬이 된 노드니까 제외하고 다시 힙만들고 하면서 반복
 */
public class HeapSort {
    public static int[] numbers = {4,3,2,7,6,5,1,10,9,8};

    public static void swap(int[] array, int idx1, int idx2){
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static void heapify(int array[], int n, int i) {
        int p = i;
        int l = i * 2 + 1;
        int r = i * 2 + 2;

        if (l < n && array[p] < array[l]) {
            p = l;
        }
        if (r < n && array[p] < array[r]) {
            p = r;
        }
        if (i != p) {
            swap(array, p, i);
            heapify(array, n, p);
        }
    }

    public static void heapSort(){
        int n = numbers.length;
        // 최대힙 구조로 일단 정렬
        // n/2 - 1 이 마지막 노드의 부모 노드 (리프노드는 할 필요가 없으니까)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(numbers, n, i);
        }
        //length 하나씩 줄여가면서 제일뒤에 루트노드를 옮김
        for (int i = n - 1; i > 0; i--) {
            swap(numbers, 0, i);
            heapify(numbers, i, 0);
        }
        for (int v : numbers) {
            System.out.println(v);
        }
    }
}
