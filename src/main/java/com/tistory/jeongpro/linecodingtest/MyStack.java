package com.tistory.jeongpro.linecodingtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 괄호 짝 검사
 */
public class MyStack {
    public int solution(String inputString) {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(char c : inputString.toCharArray()){
            boolean isError = false;
            List<Character> charList = new ArrayList<>();
            switch (c){
                case '(': case '{': case '[': case '<':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.isEmpty()){
                        isError = true;
                    }
                    while(!stack.isEmpty()) {
                        char pop = stack.pop();
                        if('(' == pop){
                            count++;
                            if(charList.size() > 0){
                                charList.forEach(x->stack.push(x));
                            }
                        }else{
                            charList.add(pop);
                        }
                    }
                    break;
                case ']':
                    if(stack.isEmpty()){
                        isError = true;
                    }
                    while(!stack.isEmpty()) {
                        char pop = stack.pop();
                        if('[' == pop){
                            count++;
                            if(charList.size() > 0){
                                charList.forEach(x->stack.push(x));
                            }
                        }else{
                            charList.add(pop);
                        }
                    }
                    break;
                case '}':
                    if(stack.isEmpty()){
                        isError = true;
                    }
                    while(!stack.isEmpty()) {
                        char pop = stack.pop();
                        if('{' == pop){
                            count++;
                            if(charList.size() > 0){
                                charList.forEach(x->stack.push(x));
                            }
                        }else{
                            charList.add(pop);
                        }
                    }
                    break;
                case '>':
                    if(stack.isEmpty()){
                        isError = true;
                    }
                    while(!stack.isEmpty()) {
                        char pop = stack.pop();
                        if('<' == pop){
                            count++;
                            if(charList.size() > 0){
                                charList.forEach(x->stack.push(x));
                            }
                        }else{
                            charList.add(pop);
                        }
                    }
                    break;
            }
            if(isError){
                return -1;
            }
            if(charList.size() > 0){
                return -1;
            }
        }
        return count;
    }
}
