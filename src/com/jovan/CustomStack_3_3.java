package com.jovan;

import java.util.ArrayList;

public class CustomStack_3_3 {
    public static void main(String[] args) throws CustomStackException{
        CustomStack_3_3 x = new CustomStack_3_3();

        StackOfPlates<Integer> stack = x.new StackOfPlates();

        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(0);
//        stack.push("asd");
//        stack.push("asd/Jv");
//        stack.push(1.1);
        stack.push(1);

        System.out.println("popping: " + stack.pop());
        System.out.println("popping: " + stack.pop());

        stack.printStackOfPlates();

    }


    public class CustomStackNode<T> {
        private T value;
        private CustomStackNode<T> next;
        public CustomStackNode(T value, CustomStackNode<T> next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {return value;}
        public CustomStackNode<T> getNext() {return next;}
    }

    public class CustomStack<T> {
        private CustomStackNode<T> top;
        private int height = 0;

        public int getHeight() {return height;}

        public void push(T value) {
            top = new CustomStackNode<>(value, top);
            height++;
        }

        public T pop() throws CustomStackException {
            if (top == null) {
                throw new CustomStackException("stack is empty");
            }

            T ret = top.getValue();
            top = top.getNext();
            height--;
            return ret;
        }

        public T peek() {
            if (top == null) {
                return null;
            }
            return top.getValue();
        }
    }

    public class StackOfPlates<T> {
        private ArrayList<CustomStack<T>> stacks;
        private final int MAX_STACK_SIZE = 3;

        public StackOfPlates() {
            stacks = new ArrayList<>();
            stacks.add(new CustomStack<>());
        }

        public void push(T value) {
            CustomStack<T> currentStack = stacks.get(getCurrentStackIdx());
            if (currentStack.getHeight() == MAX_STACK_SIZE) {
                currentStack = new CustomStack<T>();
                stacks.add(currentStack);
            }
            currentStack.push(value);
        }

        public T pop() throws CustomStackException {
            CustomStack<T> currentStack = stacks.get(getCurrentStackIdx());
            if (currentStack.peek() == null) {
                currentStack = decreaseCurrentStack();
            }
            return currentStack.pop();
        }

        // if on the first stack, popping the element will be handled by the CustomStack class (exception or otherwise)
        private CustomStack<T> decreaseCurrentStack() {
            if (getCurrentStackIdx() == 0) {
                return stacks.get(0);
            } else {
                stacks.remove(getCurrentStackIdx());
                return stacks.get(getCurrentStackIdx());
            }
        }

        private int getCurrentStackIdx() {
            return stacks.size() - 1;
        }

        public void printStackOfPlates() throws CustomStackException {
            for (int i = 0; i < stacks.size(); ++i) {
                System.out.println("printing sub stack " + i);
                while (stacks.get(i) != null && stacks.get(i).peek() != null) {
                    System.out.print(stacks.get(i).pop() + ", ");
                }
                System.out.println("\n======================");
            }
        }
    }

    public class CustomStackException extends Exception {
        public CustomStackException(String msg) {
            super(msg);
        }
    }
}
