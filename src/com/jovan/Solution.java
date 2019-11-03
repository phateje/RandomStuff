package com.jovan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution x = new Solution();


        int[] a = {4,3,2,5,1,1};
        System.out.println(x.solution(a));

    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length < 2) {
            return 0;
        }

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> rightAbsSorted = new ArrayList<>();
        int maxLeft = 0;
        int minRight = 0;

        left.add(A[0]);
        maxLeft = A[0];

        for (int i = 1; i < A.length; ++i) {
            int a = A[i];
            right.add(a);
            rightAbsSorted.add(a);
            if (i == 1) {
                minRight = a;
            } else if (minRight > a) {
                minRight = a;
            }

        }
        Collections.sort(rightAbsSorted);

        int maxDiff = maxLeft - minRight;
        System.out.println("init max diff: " + maxDiff);
        int maxDiffIdx = 0;
        int idx = 0;
        while (right.size() > 1) {
            ++idx;
            Integer nextBreakpoint = right.get(0);
            right.remove(0);
            rightAbsSorted.remove(nextBreakpoint);
            minRight = rightAbsSorted.get(0);

            if (nextBreakpoint > maxLeft) {
                maxLeft = Math.abs(nextBreakpoint);
            }

            int currentDelta = maxLeft - minRight;
            System.out.println("current delta found: " + currentDelta);
            if (currentDelta > maxDiff) {
                maxDiff = currentDelta;
                maxDiffIdx = idx;
            }
        }

        System.out.println("max diff found: " + maxDiff);
        return maxDiffIdx;
    }
}