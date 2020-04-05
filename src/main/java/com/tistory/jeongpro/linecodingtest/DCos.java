package com.tistory.jeongpro.linecodingtest;

import java.util.*;
import java.util.stream.Collectors;

public class DCos {
    public String[] solution(String[][] dataSource, String[] tags) {
        List<MyClass> list = new ArrayList<>();
        Set<String> myTags = new HashSet<>();
        for(String tag : tags){
            myTags.add(tag);
        }
        for(int i=0;i<dataSource.length;i++){
            int count = 0;
            for(int j=0;j<dataSource[i].length;j++){
                if(j!=0) {
                    if(myTags.contains(dataSource[i][j])){
                        count++;
                    }
                }
            }
            if(count > 0) {
                list.add(new MyClass(dataSource[i][0], count));
            }
        }
        Collections.sort(list, MyClass::compareTo);
        List<MyClass> subList;
        if(list.size() > 10){
            subList = list.subList(0,10);
        }else{
            subList = list;
        }
        List<String> names = subList.stream().map(myClass -> myClass.getName())
                .collect(Collectors.toList());
        String[] answer = new String[names.size()];
        int size = 0;
        for(String name : names){
            answer[size++] = name;
        }
        return answer;
    }
    static class MyClass{
        private String name;
        private int count;
        public MyClass(String name, int count){
            this.name = name;
            this.count = count;
        }
        public int compareTo(MyClass o) {
            if(o.count == this.count){
                return this.name.compareTo(o.name);
            }else{
                return o.count - this.count;
            }
        }
        public String getName(){
            return this.name;
        }
    }
}

