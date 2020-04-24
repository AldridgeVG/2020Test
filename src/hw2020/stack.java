package hw2020;

import java.util.Scanner;
import java.util.Stack;

public class stack {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(new stack().isValid(s));
    }

    public boolean isValid(String s) {
        int n = s.length();
        Stack<Integer> ss = new Stack();

        for(int i =0;i<n;i++){
            switch(s.charAt(i)){
                case '(':
                    ss.push(1);
                    break;
                case '[':
                    ss.push(2);
                    break;
                case '{':
                    ss.push(3);
                    break;
                case ')':{
                    if(ss.isEmpty())return false;
                    if(ss.pop()!=1) return false;
                    break;
                }
                case ']':{
                    if(ss.isEmpty())return false;
                    if(ss.pop()!=2) return false;
                    break;
                }
                case '}':{
                    if(ss.isEmpty())return false;
                    if(ss.pop()!=3) return false;
                    break;
                }
                default: continue;
            }
        }
        if(ss.isEmpty()) return true;
        else return false;
    }

}
