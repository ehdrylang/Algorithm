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
}
