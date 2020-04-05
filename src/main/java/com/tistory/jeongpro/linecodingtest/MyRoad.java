package com.tistory.jeongpro.linecodingtest;

public class MyRoad {
    public int solution(String road, int n) {
        int bosu = n;
        int max = findMax(road, n);
        int count = 0;
        int idx = 0;
        boolean isFirst = false;

        for(int i=0;i<road.length();i++){
            char c = road.charAt(i);
            if(c == '0'){
                count = findMax(road.substring(i+1), n);
                if(max < count){
                    max = count;
                }
            }
        }
        return max;
    }
    public int findMax(String road, int n){
        int count = 0;
        for(int i=0;i<road.length();i++){
            char c = road.charAt(i);
            if(c=='0'){
                if(n > 0){
                    count++;
                    n--;
                }else if(n == 0) {
                    return count;
                }
            }else if(c == '1'){
                count++;
            }
        }
        return count;
    }
}
