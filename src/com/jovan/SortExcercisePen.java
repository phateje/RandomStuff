package com.jovan;

public class SortExcercisePen {

    public static void main(String[] args) {
        SortExcercisePen sorter = new SortExcercisePen();
        int[] anArray = {7, -5, 3, 2, 1, 0, 45};
        int[] originalArray = anArray.clone();

//        int[] sorted = sorter.mergeSort(anArray);
        sorter.quickSort(anArray);
        for (int i = 0; i < anArray.length; ++i) {
            System.out.println(originalArray[i] + "\t|\t" + anArray[i]);
        }
    }


    public int[] mergeSort(int[] anArray) {
        return mergeSort(anArray, 0, anArray.length-1);
    }
    private int[] mergeSort(int[] array, int start, int end) {
        if (start == end) {
            return new int[]{array[start]};
        }

        int mid = start + end >>> 1;
        int[] left = mergeSort(array, start, mid);
        int[] right = mergeSort(array, mid + 1, end);
        return merge(left, right);
    }
    private int[] merge(int[] left, int[] right) {
        int lowLeft = 0;
        int lowRight = 0;
        int[] ret = new int[left.length + right.length];
        while (lowLeft < left.length || lowRight < right.length) {
            if (lowLeft == left.length) {
                ret[lowLeft + lowRight] = right[lowRight];
                lowRight++;
            } else if (lowRight == right.length) {
                ret[lowLeft + lowRight] = left[lowLeft];
                lowLeft++;
            } else {
                if (left[lowLeft] <= right[lowRight]) {
                    ret[lowLeft + lowRight] = left[lowLeft];
                    lowLeft++;
                } else {
                    ret[lowLeft + lowRight] = right[lowRight];
                    lowRight++;
                }
            }
        }
        return ret;
    }

    public void quickSort(int[] array) {
        quickSort(array, 0, array.length-1);
    }
    private void quickSort(int[] array, int start, int end) {
        if (start >= end) return;

        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }
    private int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int minIdx = start-1;
        for (int i = start; i <= end; ++i) {
            if (array[i] <= pivot) {
                // last element is the pivot itself, so <= means we'll swap, after that minIdx will be the position of the pivot
                minIdx++;
                swap(array, i, minIdx);
            }
        }
        return minIdx;
    }
    private void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }
}
