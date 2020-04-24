package hw2020;
import java.util.*;

public class searchNum {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        if(!in.hasNext()) return;
        String origin = in.nextLine();
        int n = origin.length();
        ArrayList<Integer> arr = new ArrayList();
        for(int i=0;i<n;i++){
            char ch = origin.charAt(i);
            if(ch >='0'&& ch <='9') arr.add(new Integer(ch-'0'));
        }
        int[] a = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            a[i] = Integer.valueOf(arr.get(i));
        }
        Arrays.sort(a);
        System.out.println();
        for(int i:a){
            System.out.print(i);
        }
    }
}
