package com.jovan;

import java.util.ArrayList;

public class BinaryTreeInNTime {
    public static void main(String[] args) {

    }


    public static void buildFromArray(Node parent, Integer hiLeft, Integer loRight) {

    }

    public static class Node {
        private int i;
        public Node leftChild, rightChild;


        public Node(int i) {
            this.i = i;
        }

        public String toString() {
            String ret = "[" + i + "(left = ";
            if (leftChild != null) {
                ret += leftChild.toString();
            } else {
                ret += "null";
            }

            ret += "; right = ";
            if (rightChild != null) {
                ret += rightChild.toString();
            } else {
                ret += "null";
            }
            ret += ")]";
            return ret;
        }
    }
}
