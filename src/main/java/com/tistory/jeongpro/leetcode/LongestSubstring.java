package com.tistory.jeongpro.leetcode;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(String str : s.split("")){
            if (sb.indexOf(str) != -1) {
                int length = sb.length();
                if (answer < length) {
                    answer = length;
                }
                sb.delete(0,sb.indexOf(str)+1);
            }
            sb.append(str);
        }
        if(answer < sb.length()){
            return sb.length();
        }
        return answer;
    }
}
