package demo;

import stack.Stack;
import stack.StackImpl;

public class StackDemo {
    public static void main(String[] args) {
        System.out.println("Stack OOP");
        Stack stack = new StackImpl();
        System.out.println("Stack is empty " + stack.isEmpty());
        stack.push("B");
        stack.push(3);
        stack.push("B");
        stack.push(0);
        stack.push(8);
        System.out.println("Stack is empty " + stack.isEmpty());
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }



        System.out.println("Stack Array");
        Stack stack2 = new StackImpl();
        System.out.println("Stack is empty " + stack.isEmpty());
        stack2.push("B");
        stack2.push(3);
        stack2.push("B");
        stack2.push(0);
        stack2.push(8);
        System.out.println("Stack is empty " + stack.isEmpty());
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }



    }
}
