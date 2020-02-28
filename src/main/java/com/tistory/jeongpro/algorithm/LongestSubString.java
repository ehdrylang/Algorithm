package com.tistory.jeongpro.algorithm;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        String result = "";
        int maxlength = 0;
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(result.contains(String.valueOf(arr[i]))){
                result = result.substring(result.indexOf(arr[i]) + 1);
            }
            result += arr[i];
            if(maxlength < result.length()){
                maxlength = result.length();
            }
        }
        return maxlength;
    }
}
