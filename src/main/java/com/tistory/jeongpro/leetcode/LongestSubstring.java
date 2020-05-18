package com.tistory.jeongpro.leetcode;

import java.util.HashMap;
import java.util.Map;

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
        int max_len=0;
        int start=0, end=0;
        int len=0;
        Map<Character,Integer> hmap=new HashMap<>();
        while(start<=end && end<s.length())
        {
            if(!hmap.containsKey(s.charAt(end)))
            {
                hmap.put(s.charAt(end),1);
                end++;
                len++;
            }
            else
            {
                if(len>max_len) max_len=len;
                len--;
                hmap.remove(s.charAt(start));
                start++;
            }
        }
        if(len>max_len) max_len=len;
        return max_len;
    }
}
