package com.jovan;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class FindCommonAncestorBinaryTree {

    public static void main(String[] args) {
        FindCommonAncestorBinaryTree x = new FindCommonAncestorBinaryTree();

        /*
                     root
                    /    \
                   a      b
                  /\     /\
                 c  d   e  f
                /\
               g  h
                   \
                    i
         */
        Node root = x.new Node("root");
        root.leftChild = x.new Node("a");
        root.rightChild = x.new Node("b");

        root.leftChild.leftChild = x.new Node("c");
        root.leftChild.rightChild = x.new Node("d");

        root.rightChild.leftChild = x.new Node("e");
        root.rightChild.rightChild = x.new Node("f");

        root.leftChild.leftChild.leftChild = x.new Node("g");
        root.leftChild.leftChild.rightChild = x.new Node("h");

        root.leftChild.leftChild.rightChild.rightChild = x.new Node("i");

        System.out.println();
        LinkedList<Node> pathToI = findPathToNode(root, x.new Node("i"));
        printPath(pathToI);

        LinkedList<Node> pathToD = findPathToNode(root, x.new Node("d"));
        printPath(pathToD);
    }

    public class Node {
        public String name;

        public Node leftChild;
        public Node rightChild;

        public Node(String name) {this.name = name;}

        public boolean equals(@NotNull Node n) {
            return n.name == this.name;
        }
    }

    public static LinkedList<Node> findPathToNode(Node n, Node target) {
        LinkedList<Node> ret = new LinkedList<>();
        findPathToNode(n, target, ret);
        Collections.reverse(ret);
        if (ret.getLast().equals(target)) {
            return ret;
        } else {
            return null;
        }
    }

    public static boolean findPathToNode(Node n, Node target, LinkedList<Node> ret) {
        if (n == null) {
            return false;
        }

        if (n.equals(target) || findPathToNode(n.leftChild, target, ret) || findPathToNode(n.rightChild, target, ret)) {
            ret.add(n);
            return true;
        }
        return false;
    }

    public static void printPath(LinkedList<Node> path) {
        ArrayList<String> s = new ArrayList<>();
        for (Node n : path) {
            s.add(n.name);
        }
        System.out.println(String.join(" -> ", s));
        System.out.println();
    }
}
