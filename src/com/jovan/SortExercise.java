package com.jovan;

public class SortExercise {
    public static void main(String[] args) {
        SortExercise sorter = new SortExercise();
        int[] anArray = {7, -5, 3, 2, 1, 0, 45};
        int[] originalArray = anArray.clone();

//        int[] sorted = sorter.mergeSort(anArray);
        sorter.quickSort(anArray);
        for (int i = 0; i < anArray.length; ++i) {
            System.out.println(originalArray[i] + "\t|\t" + anArray[i]);
        }
    }



    public int[] mergeSort(int[] arrayToSort) {
        return mergeSort(arrayToSort, 0, arrayToSort.length - 1);
    }
    private int[] mergeSort(int[] anArray, int startIdx, int endIdx) {
        if (startIdx == endIdx) {
            int[] ret = new int[1];
            ret[0] = anArray[startIdx];
            return ret;
        }

        int m = startIdx + endIdx >>> 1;
        int[] leftArray = new int[m - startIdx + 1];
        int[] rightArray = new int[endIdx - m];
        leftArray = mergeSort(anArray, startIdx, m);
        rightArray = mergeSort(anArray, m + 1, endIdx);

        // further optimize by passing reference to parent array to repopulate instead of creating new one?
        return merge(leftArray, rightArray);
    }
    private int[] merge(int[] leftArray, int[] rightArray) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;

        int currentLeftIdx = 0;
        int currentRightIdx = 0;
        int[] ret = new int[leftSize + rightSize];

        do {
            // handle index out of bounds first
            if (currentRightIdx == rightSize) {
                ret[currentLeftIdx + currentRightIdx] = leftArray[currentLeftIdx];
                currentLeftIdx++;
            } else if (currentLeftIdx == leftSize) {
                ret[currentLeftIdx + currentRightIdx] = rightArray[currentRightIdx];
                currentRightIdx++;
            } else {
                // handle regular iteration
                if (leftArray[currentLeftIdx] < rightArray[currentRightIdx]) {
                    ret[currentLeftIdx + currentRightIdx] = leftArray[currentLeftIdx];
                    currentLeftIdx++;
                } else {
                    ret[currentLeftIdx + currentRightIdx] = rightArray[currentRightIdx];
                    currentRightIdx++;
                }
            }
        } while (!(currentLeftIdx == leftSize && currentRightIdx == rightSize));

        return ret;
    }


    public void quickSort(int[] arrayToSort) {
        quickSort(arrayToSort, 0, arrayToSort.length - 1);
    }

    private void quickSort(int[] arrayToSort, int startIdx, int endIdx) {
        if (startIdx >= endIdx)
            return;

        int pivotIdx = partition(arrayToSort, startIdx, endIdx);
        quickSort(arrayToSort, startIdx, pivotIdx-1);
        quickSort(arrayToSort, pivotIdx+1, endIdx);
    }

    private int partition(int[] arrayToSort, int low, int high) {
        int pivot = arrayToSort[high];
        int midIdx = low - 1;

        for (int i = low; i < high; ++i) {
            if (arrayToSort[i] <= pivot) {
                ++midIdx;
                swap(arrayToSort, midIdx, i);
            }
        }
        swap(arrayToSort, midIdx+1, high);
        return midIdx+1;
    }

    private void swap(int[] array, int i1, int i2) {
        int c = array[i1];
        array[i1] = array[i2];
        array[i2] = c;
    }

}