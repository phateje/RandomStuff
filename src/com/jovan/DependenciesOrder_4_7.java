package com.jovan;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DependenciesOrder_4_7 {
    public static void main(String[] args) {

        ArrayList<Character> nodes = new ArrayList<>();
        nodes.add('a');
        nodes.add('b');
        nodes.add('c');
        nodes.add('d');
        nodes.add('e');
        nodes.add('f');
        nodes.add('g');

        ArrayList<Pair<Character, Character>> adjacency = new ArrayList<>();
        adjacency.add(new Pair<>('f', 'c'));
        adjacency.add(new Pair<>('f', 'a'));
        adjacency.add(new Pair<>('f', 'b'));
        adjacency.add(new Pair<>('d', 'g'));
        adjacency.add(new Pair<>('c', 'a'));
        adjacency.add(new Pair<>('b', 'a'));
        adjacency.add(new Pair<>('a', 'e'));
        adjacency.add(new Pair<>('b', 'e'));

        System.out.println(buildDependencyOrder(nodes, adjacency));
    }


    public static ArrayList<Character> buildDependencyOrder(ArrayList<Character> tasks, ArrayList<Pair<Character, Character>> dependencies) {
        ArrayList<Character> ret = new ArrayList<>();
        HashSet<Character> visitedTasks = new HashSet<>();
        HashSet<Character> rightSet = new HashSet<>();
        for (Pair<Character, Character> p : dependencies) {
            rightSet.add(p.getValue());
        }

        while (!tasks.isEmpty()) {
            // "complete" tasks that are not dependent on anything
            ArrayList<Character> tasksToComplete = new ArrayList<>();
            for (Character task : tasks) {
                if (!rightSet.contains(task)) {
                    tasksToComplete.add(task);
                }
            }

            ret.addAll(tasksToComplete);
            tasks.removeAll(tasksToComplete);

            // remove edges that require already completed tasks
            ArrayList<Pair<Character, Character>> depToRemove = new ArrayList<>();
            for (Pair<Character, Character> p : dependencies) {
                if (ret.contains(p.getKey())) {
                    rightSet.remove(p.getValue());
                    depToRemove.add(p);
                } else {
                    rightSet.add(p.getValue());
                }
            }
            dependencies.removeAll(depToRemove);

            if (!rightSet.isEmpty() && tasksToComplete.isEmpty()) {
                return null;
            }
        }


        return ret;
    }

}
