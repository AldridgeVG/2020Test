package hw2020;

import java.util.*;

public class vote1 {

    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNext()) {
            System.out.println("error.0001");
            return;
        }
        String names = in.next();
        String name[] = names.split("\\,");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            //check validity
            if (name[i].charAt(0) < 'A' || name[i].charAt(0) > 'Z') {
                System.out.println("error.0001");
                return;
            }
            for (int j = 1; j < name[i].length(); j++) {
                if (name[i].charAt(j) < 'a' || name[i].charAt(j) > 'z') {
                    System.out.println("error.0001");
                    return;
                }
            }

            //put into map or inc count
            if (!map.containsKey(name[i])) map.put(name[i], 1);
            else map.replace(name[i], map.get(name[i]) + 1);
        }

        //traverse to get max
        Integer max = new Integer(0);
        String maxs = "";
        for (String tmp : map.keySet()) {
            if (map.get(tmp) > max) {
                max = map.get(tmp);
                maxs = tmp;
            }
            if (map.get(tmp).equals(max)) {
                if (maxs.compareTo(tmp) > 0) {
                    maxs = tmp;
                }
            }
        }
        System.out.println(maxs);
    }

}
