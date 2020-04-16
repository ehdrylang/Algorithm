package com.tistory.jeongpro.leetcode;

import java.util.ArrayList;
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
}
