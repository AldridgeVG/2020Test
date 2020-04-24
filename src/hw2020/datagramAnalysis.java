package hw2020;

import java.util.Scanner;

public class datagramAnalysis {
    public static int hexStringToInt(String s) {
        int n = 0;
        if (s.length() != 2) return -1;
        else {
            char ch0 = s.charAt(1);
            char ch1 = s.charAt(0);
            int tmp0 = 0;
            int tmp1 = 0;
            if (ch0 >= '0' && ch0 <= '9') tmp0 = ch0 - '0';
            else if (ch0 >= 'a' && ch0 <= 'f') tmp0 = (ch0 - 'a') + 11;
            else return -1;
            if (ch1 >= '0' && ch1 <= '9') tmp1 = ch1 - '0';
            else if (ch1 >= 'a' && ch1 <= 'f') tmp1 = (ch1 - 'a') + 11;
            else return -1;
            n = n + 1 * tmp0 + 16 * tmp1;
        }
        return n;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        String input = null;
        if (in.hasNextLine()) input = in.nextLine();
        else return;
        //get grams
        String[] grams = input.split("5a");
        int num = grams.length;
        int valid[] = new int[num];
        StringBuilder[] corrected = new StringBuilder[num];
        //check each gram
        for (int i = 0; i < grams.length; i++) {
            //get hex string[]
            String[] bytes = grams[i].split(" ");
            if (bytes.length == 0) continue;
            if (bytes.length == 1 && bytes[0].equals("")) continue;
            if (bytes.length == 2 && !bytes[1].equals("01")) continue;
            //get length to be
            String glength = bytes[bytes.length - 1];
            int actualLen = bytes.length - 2;
            int gramLen = hexStringToInt(glength);
            //get actual length
            for (int j = 0; j < bytes.length - 1; j++) {
                if (j > 0) {
                    if (bytes[j].equals("ba") || bytes[j].equals("bb")) {
                        if (bytes[j - 1].equals("5b")) actualLen--;
                    }
                }
            }
            if (actualLen == gramLen) valid[i] = 1;
            //if valid form new gram
            if (valid[i] == 1) {
                for (int j = 0; j < bytes.length - 1; j++) {
                    if (j > 0 && j < bytes.length - 2 && bytes[j].equals("5b")) {
                        if (bytes[j + 1] == "ba") {
                            corrected[i].append(" 5a");
                            j++;
                        } else if (bytes[j + 1] == "bb") {
                            corrected[i].append(" 5b");
                            j++;
                        } else corrected[i].append(" 5b");
                    } else {
                        corrected[i].append(" " + bytes[j]);
                    }
                }
                corrected[i].append(glength + " ");
            }
        }

        //dealt with all grams, remake
        StringBuilder sb = new StringBuilder();
        sb.append("5a");
        for (int i = 0; i < num; i++) {
            if (valid[i] == 1) {
                sb.append(corrected[i].toString());
                sb.append("5a");
            }
        }

        System.out.println(sb.toString());
    }
}
