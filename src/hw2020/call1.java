package hw2020;

import java.util.Arrays;
import java.util.Scanner;

public class call1 {

    //global variables
    public static boolean[] visited;    //signify if a func is visited in dfs
    public static int[] stack;          //array of func stack size
    public static int[][] mat;          //init call stack
    public static int max;              //max stack size

    public static void main(String[] args) {
        max = 0;
        Scanner in = new Scanner(System.in);

        //signify if any func has no stack usage to return NA
        boolean flag = true;

        //get 1st line:n call1 call2...
        String[] ss = in.nextLine().split(" ");
        int n = Integer.parseInt(ss[0]);

        //mat init 0
        visited = new boolean[n];
        mat = new int[n][n];
        stack = new int[n];
        for (int i = 0; i < n; i++) {
            String[] s = in.nextLine().split(" ");
            if (s.length == 1) {
                flag = false;
                break;
            } else {
                //get this func's size
                stack[i] = Integer.parseInt(s[1]);
                //get this's callee
                String[] thisCall = Arrays.copyOfRange(s, 2, s.length);
                for (int j = 0; j < thisCall.length; j++) {
                    int tmp = Integer.parseInt(thisCall[j]) - 1;
                    //illegal
                    if (tmp >= n || tmp < 0) {
                        break;
                    }
                    //means i calls tmp
                    mat[i][tmp] = 1;
                }
            }
        }
        //start from each func, init sum as stack[cur]
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            int sum = stack[i];
            int[] tmp = mat[i];
            for (int j = 0; j < tmp.length; j++) {
                if (visited[j] == false && tmp[j] == 1) {
                    visited[j] = true;
                    dfs(j, sum + stack[j]);
                    visited[j] = false;
                }
            }
        }
        if (flag == false) System.out.println("NA");
        else System.out.println(max);

    }

    public static boolean allCalleeVisited(int i) {
        //get func i's call
        int[] res = mat[i];
        for (int j = 0; j < res.length; j++) {
            if (res[j] == 1 && visited[j] == false) return false;
        }
        return true;
    }

    public static void dfs(int i, int sum) {
        //end of one round dfs
        if (allCalleeVisited(i)) {
            max = Math.max(max, sum);
            return;
        }
        //traverse this i's call stack
        int[] tmp = mat[i];
        for (int j = 0; j < tmp.length; j++) {
            //not visited, visit it and add to path, add to sum
            if (visited[j] == false && tmp[j] == 1) {
                visited[j] = true;
                dfs(j, sum + stack[j]);
                //after dfs return, set all routed node visited to false for next path
                visited[j] = false;
            }
        }
    }
}
