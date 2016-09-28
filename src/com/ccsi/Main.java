package com.ccsi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    String s="I am a (good) student, [you should be a {good} one] too.";
        System.out.println(isValid(s));
    }
    //Given a string containing just the characters '(',')','{','}','[',']',determine if the input string is valid.
    //The brackets must close in the correct order,"()"and"(){}[]" are all valid but "(]" and "([)]" are not.
    public static boolean isValid(String s){
        if(s==null||s.length()==0)return false;
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(")}]".contains(String.valueOf(s.charAt(i)))&&stack.isEmpty())return false;  //判断是否以反括号出现在前面
            if("({[".contains(String.valueOf(s.charAt(i)))){
                stack.push(s.charAt(i));
            }else{
                if(!stack.isEmpty()&&isPair(stack.peek(),s.charAt(i))){
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
    public static boolean isPair(char c1,char c2){
        if(c1=='('&&c2==')')return true;
        if(c1=='{'&&c2=='}')return true;
        if(c1=='['&&c2==']')return true;
        return false;
    }
}
