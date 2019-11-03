package com.jovan;

import java.util.Iterator;
import java.io.Reader;
import java.io.IOException;
import java.util.LinkedList;

class SolutionIter implements Iterable<Integer> {
    private static final char SEPARATOR = 10;
    private static final Integer MIN_VALUE = -1000000000;
    private static final Integer MAX_VALUE = +1000000000;

    private LinkedList<Integer> intValues;

    public SolutionIter(Reader inp) {
        intValues = new LinkedList<>();

        try {
            StringBuilder strBuilder = new StringBuilder();
            int data = inp.read();
            while (data != -1) {
                char d = (char) data;

                if (d == SEPARATOR) {
                    addIntToList(strBuilder.toString().trim());
                    strBuilder.setLength(0);
                } else {
                    strBuilder.append(d);
                }
                data = inp.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * tries to parse a valid Integer value out of the string
     * if valid, it adds it to the list
     * @param str the line to parse
     */
    private void addIntToList(String str) {
        try {
            Integer i = Integer.valueOf(str);
            if (MIN_VALUE <= i && i <= MAX_VALUE) {
                intValues.add(Integer.valueOf(str));
            }
        } catch (NumberFormatException e) {
            // invalid Integer value. Do nothing
        }
    }

    public Iterator<Integer> iterator() {
        return intValues.iterator();
    }
}

/**
 * Example usage:
 *
 * for (Integer x : new SolutionIter(reader)) {
 *     System.out.println(x);
 * }
 */
