package com.jovan;

public class RotateMatrix {

    public static void main (String[] args) {
        int[][] m1 = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] rotatedM = rotate(m1);
        int[][] rotatedM2 = rotate(rotatedM);
        int[][] rotatedM3 = rotate(rotatedM2);
        int[][] rotatedM4 = rotate(rotatedM3);
        printArray(m1);
        System.out.println("===================");
        printArray(rotatedM);
        System.out.println("===================");
        printArray(rotatedM2);
        System.out.println("===================");
        printArray(rotatedM3);
        System.out.println("===================");
        printArray(rotatedM4);
    }


    public static int[][] rotate(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;

        int[][] rotatedM = new int[cols][rows];

        for (int rowIdx = 0; rowIdx < rows; ++rowIdx) {
            int newColIdx = rows - 1 - rowIdx;
            for (int newRowIdx = 0; newRowIdx < cols; newRowIdx++) {
                rotatedM[newRowIdx][newColIdx] = m[rowIdx][newRowIdx];
            }
        }
        return rotatedM;
    }

    public static void printArray(int[][] ar) {
        for (int[] row : ar) {
            for (int v : row) {
                System.out.print(v + "\t");
            }
            System.out.println();
        }
    }
}
