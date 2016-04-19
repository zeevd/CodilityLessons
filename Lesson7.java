package main.java.Codility;

import java.util.EmptyStackException;
import java.util.Stack;

public class Lesson7 {


    public int brackets(String S) {
        if (S==null || S.isEmpty()) return 1;
        Stack<Character> stack = new Stack<Character>();

        try{
            for (int i=0; i<S.length(); i++){
                char current = S.charAt(i);
                if (current == '(' || current == '[' || current == '{')
                    stack.push(current);
                else if (current == ')' && stack.peek() == '(') stack.pop();
                else if (current == ']' && stack.peek() == '[') stack.pop();
                else if (current == '}' && stack.peek() == '{') stack.pop();
                else return 0; //invalid character
            }
            return (stack.isEmpty() ? 1 : 0);
        } catch (EmptyStackException e){
            return 0;
        }
    }

    public int nesting(String S) {
        if (S==null || S.isEmpty()) return 1;
        Stack<Character> stack = new Stack<Character>();

        for (int i=0; i<S.length(); i++){
            char currChar = S.charAt(i);
            if (currChar == '(') stack.push(currChar);
            else{  //currChar==')'
                if (!stack.isEmpty()) stack.pop();
                else return 0;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
