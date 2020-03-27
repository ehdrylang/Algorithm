package com.tistory.jeongpro.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 문제 easy
 */
public class CountAndSay {
    /**
     * solution
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        List<String> list = new ArrayList<>();
        //초기 값
        list.add("1");
        if(n == 1){
            return list.get(0);
        }
        while(list.size() < n){
            int size = list.size();
            String value = list.get(size-1);
            StringBuilder temp = new StringBuilder();
            for(int i=0;i<value.length();i++){
                int count = 1;
                int j = i;
                char curr = value.charAt(i);
                while( ++j != value.length()){
                    char next = value.charAt(j);
                    if(curr == next){
                        count++;
                        i++;
                    }else{
                        break;
                    }
                }
                temp.append(count).append(curr);
            }
            list.add(temp.toString());
        }
        return list.get(n-1);
    }
}
