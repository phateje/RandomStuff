package com.jovan;

public class InvertStringInPlace {

    public static void main(String[] args) {
        String s = "a fucken strings";

        System.out.println(invertStr(invertStr(s)));
    }

    public static String invertStr(String s) {
        int length = s.length();
        int endIdx = length - 1;

        char[] charray = s.toCharArray();
        for (int i = 0; i < length / 2 + length % 2; ++i) {
            char temp = charray[i];
            charray[i] = charray[endIdx - i];
            charray[endIdx - i] = temp;
        }
        return new String(charray);
    }
}
