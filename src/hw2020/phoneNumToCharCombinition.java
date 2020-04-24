package hw2020;

import java.util.*;

public class phoneNumToCharCombinition {
    public static String[][] chs;
    public static List<String> ret;


    public static void Apd(int i, StringBuilder sb, int n){
        if(chs[i] == null){
            if(i == n-1){
            }
            else {
                Apd(i+1,sb,n);
            }
        }else{
            for(int j=0;j<chs[i].length;j++){
                StringBuilder ms = new StringBuilder(sb.append(chs[i][j]));
                sb.deleteCharAt(sb.length()-1);
                if(i == n-1){
                    ret.add(ms.toString());
                }
                else {
                    Apd(i+1,ms,n);
                }
            }
        }
        return;
    }

    public static List<String> letterCombinations(String digits) {
        ret = new ArrayList();
        if(digits.equals("")) return ret;

        HashMap<Integer,String[]> map = new HashMap();
        map.put(2,new String[]{"a","b","c"});
        map.put(3,new String[]{"d","e","f"});
        map.put(4,new String[]{"g","h","i"});
        map.put(5,new String[]{"j","k","l"});
        map.put(6,new String[]{"m","n","o"});
        map.put(7,new String[]{"p","q","r","s"});
        map.put(8,new String[]{"t","u","v"});
        map.put(9,new String[]{"w","x","y","z"});
        int n = digits.length();
        chs = new String[n][];
        for(int i=0;i<n;i++){
            if(digits.charAt(i) == '1') chs[i]=null;
            else chs[i] = map.get(new Integer(digits.charAt(i)-'0'));
        }

        Apd(0,new StringBuilder(),n);
        return ret;
    }

    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(letterCombinations(s));
    }

}
