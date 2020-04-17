package com.tistory.jeongpro.leetcode;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EasyTest {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for(char c : J.toCharArray()){
            for(char s : S.toCharArray()){
                if(c == s){
                    count++;
                }
            }
        }
        return count;
    }
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i+=2){
            for(int j=0;j<nums[i];j++){
                list.add(nums[i+1]);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
    public int subtractProductAndSum(int n) {
        int mul = 1;
        int sum = 0;
        while(n > 0){
            int value = n % 10;
            mul *= value;
            sum += value;
            n /= 10;
        }
        return mul - sum;
    }
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cache = new int[101];
        for(int i=0;i<cache.length;i++){
            cache[i] = -1;
        }
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int count = 0;
            if(cache[nums[i]] != -1){
                result[i] = cache[nums[i]];
                continue;
            }
            for(int j=0;j<nums.length;j++){
                if(nums[i] > nums[j]){
                    count++;
                }
            }
            cache[nums[i]] = count;
            result[i] = count;
        }
        return result;
    }
    public int findNumbers(int[] nums) {
        return (int) Arrays.stream(nums)
                .filter(x -> Integer.toString(x).length() % 2 == 0)
                .count();
    }
    public int balancedStringSplit(String s) {
        int count = 0;
        int check = 0;
        for(char c : s.toCharArray()){
            if(c == 'R'){
                check++;
            }else{
                check--;
            }
            if(check == 0){
                count++;
            }
        }
        return count;
    }
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            list.add(index[i], nums[i]);
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null){
            return 0;
        }
        if(root.val < L){
            return rangeSumBST(root.right, L, R);
        }
        if(root.val > R){
            return rangeSumBST(root.left, L, R);
        }
        return root.val + rangeSumBST(root.left,L,R) + rangeSumBST(root.right,L,R);
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public int getDecimalValue(ListNode head) {
        
    }
}
