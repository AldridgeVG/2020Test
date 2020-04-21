package hw2020;

import java.util.*;

//37.5%
public class vote{

    public static void main(String[]args){
        Scanner in = new Scanner(System.in);

        if(!in.hasNext()){
            System.out.println("error.0001");
            return;
        }

        String vote = in.next();
        String name[] = vote.split("\\,");
        int n = name.length;
        ArrayList<String> candidates = new ArrayList<String>();
        ArrayList<Integer> voteNum = new ArrayList<Integer>();

        int j = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){

            if(name[i].charAt(0)<'A'||name[i].charAt(0)>'Z'){
                System.out.println("error.0001");
                return;
            }

            if(sb.toString().contains(name[i])){
                int k = candidates.indexOf(name[i]);
                voteNum.set(k,voteNum.get(k)+1);
                continue;
            }
            else{
                sb.append(name[i]);
                candidates.add(name[i]);
                voteNum.add(1);
                j++;
            }
        }
        String []candi = new String[candidates.size()];
        candidates.toArray(candi);
        Integer []num = new Integer[voteNum.size()];
        voteNum.toArray(num);
        int []nm = new int[num.length];
        for(int i=0;i<nm.length;i++){
            nm[i] = num[i].intValue();
        }

        String winner = candi[0];
        int max = 0;
        int tmp = 0;
        if(nm.length>1){
            for(int i = 1;i<nm.length;i++){
                if(nm[i]>nm[max]){
                    max = i;
                    winner = candi[max];
                }
                else if(nm[i]==nm[max]){
                    if(candi[i].compareTo(candi[max]) > 0){
                        max = i;
                        winner = candi[max];
                    }
                }
                else continue;
            }
        }
        System.out.println(winner);
    }
}