package com.jovan;

import java.util.ArrayList;

public class AllPermutations {
    public static void main(String[] args) {

        ArrayList<String> random = new ArrayList<>();
        random.add("1");
        random.add("2");
        random.add("3");
//        random.add("4");

        ArrayList<ArrayList<String>> rets = new ArrayList<>();
        allPerms(rets, new ArrayList<>(), random);

        for (ArrayList<String> s : rets) {
            for (String x : s) {
                System.out.print(x + ", ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<String>> allPerms(
            ArrayList<ArrayList<String>> ret,
            ArrayList<String> currentList,
            ArrayList<String> remaining
    ) {
        if (remaining.size() == 1) {
            currentList.add(remaining.get(0));
            ret.add(currentList);
            return ret;
        }

        for (String next : remaining) {
            ArrayList<String> newRemaining = new ArrayList<>(remaining);
            newRemaining.remove(next);
            ArrayList<String> newCurrentList = new ArrayList<>(currentList);
            newCurrentList.add(next);
            allPerms(ret, newCurrentList, newRemaining);

        }
        return ret;
    }
}