package com.sud.virtusatestcode;

public class RemoveStringClass {

    public static String remove(String str1, String str2) {
        String strnew = "";
        int le1 = str1.length();
        int le2 = str2.length();
        for (int j = 0; j < le1; j++) {
            char ch1 = str1.charAt(j);
            boolean isMatched = false;
            for (int p = 0; p < le2; p++) {
                char ch2 = str2.charAt(p);
                if (ch1 == ch2) {
                    isMatched = true;
                    break;
                }
            }
            if (!isMatched) {
                strnew += ch1;
            }
        }
        return strnew;
    }
}
