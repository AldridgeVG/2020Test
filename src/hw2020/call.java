package hw2020;

import java.util.*;

public class call{
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int n=0;
        if(in.hasNextInt()){
            n= in.nextInt();
        }
        int m[] = new int[n];

        int mSize[] = new int[n];
        int call[][] = new int[101][101];

        for(int i=0;i<n;i++){
            m[i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            int line = in.nextInt();
            mSize[i] = in.nextInt();
            for(int j=0;j<m[i];j++){
                int k = in.nextInt();
                call[line][k] = 1;
            }
        }
    }
}