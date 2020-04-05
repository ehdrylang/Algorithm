package com.tistory.jeongpro.linecodingtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exam {
    public int solution(String answer_sheet, String[] sheets) {
        int answer = -1;
        int guessCount = 0;
        int maxSequence = 0;
        List<Guess> list = new ArrayList<>();
        for(int i=0;i<sheets.length;i++){
            list.add(new Guess());
        }
        for(int i=0;i<answer_sheet.length();i++){
            char dab = answer_sheet.charAt(i);
            Map<Character,Integer> map = new HashMap<>();
            for (int j=0;j<sheets.length;j++) {
                char mydab = sheets[j].charAt(i);
                if(!map.containsKey(mydab)){
                    map.put(mydab, 1);
                }else{
                    int curr = map.get(mydab);
                    map.put(mydab, curr++);
                }
            }
            for(int j=0;j<sheets.length;j++){
                char mydab = sheets[j].charAt(i);
                if(dab != mydab && map.get(mydab) > 1){
                    Guess guess = list.get(j);
                    guess.plusCount();
                }else{
                    Guess guess = list.get(j);
                    guess.stop();
                }

                if(i == answer_sheet.length()-1){
                    Guess guess = list.get(j);
                    guess.stop();
                }
            }
        }
         return list.stream()
                .map(guess -> guess.calc())
                .max(Integer::compareTo)
         .get();

    }
    static class Guess{
        private int count;//이상한거
        private int maxSize;//최대
        private int curr;//현재 최장
        public void plusCount(){
            this.count++;
            this.curr++;
        }
        public void stop(){
            if(maxSize < curr){
                maxSize = curr;
            }
            curr = 0;
        }
        public int getMaxSize(){
            return this.maxSize;
        }
        public int getCount(){
            return this.count;
        }
        public Guess(){
            this.count = 0;
            this.maxSize = 0;
        }
        public int calc(){
            return this.count + (int)Math.pow(this.maxSize, 2);
        }
    }
}
