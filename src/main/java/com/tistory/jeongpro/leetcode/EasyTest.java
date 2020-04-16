package com.tistory.jeongpro.leetcode;

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
}
