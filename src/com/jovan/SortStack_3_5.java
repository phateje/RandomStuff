package com.jovan;

import java.util.Stack;

public class SortStack_3_5 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(4);
        stack.push(3);
        stack.push(9);
        stack.push(7);
        stack.push(1);

        stack = sortStack(stack);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ", ");
        }
    }


    public static Stack<Integer> sortStack(Stack<Integer> stackToSort) {
        Stack<Integer> ret = new Stack<>();

        while (!stackToSort.isEmpty()) {
            ret.push(getMaxFromStack(stackToSort));
        }
        return ret;
    }

    // runs in 2n time, O(n), modifies original stack
    private static Integer getMaxFromStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        Integer max = stack.pop();

        while (!stack.isEmpty()) {
            if (max < stack.peek()) {
                Integer oldMax = max;
                max = stack.pop();
                tempStack.push(oldMax); // put back old max unless we're on the first cycle
            } else {
                tempStack.push(stack.pop());
            }
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return max;
    }

}
