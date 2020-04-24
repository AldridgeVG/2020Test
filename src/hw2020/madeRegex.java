package hw2020;

public class madeRegex {

    public static void main(String[] args) {
        /*
        String s = "aaaaa";
        String[] ss = s.split("\\*");
        for (String s1 : ss) {
            System.out.println(s1);
        }
        */

        String sss = "cab";
        String ppp = "c*a*b*";
        System.out.println(isMatch(sss,ppp));
    }

    public static boolean isMatch(String s, String p) {

        if(p==""&&s=="") return true;
        if(s!=""&&p=="") return false;
        if(s==""&&p.equals(".*")) return true;
        else if(s==""&&p!="") return false;

        int i = 0;
        int j = 0;
        while(i<s.length()){
            if(j>= p.length()) return false;
            char cur = s.charAt(i);
            //check validity
            if(cur>'z'||cur<'a') return false;
            //if a-z
            if(p.charAt(j)>='a'&&p.charAt(j)<='z'){
                if(s.charAt(i)==p.charAt(j)){
                    i++;j++;
                }
                else return false;
            }
            //if . all match
            else if(p.charAt(j)=='.'){
                i++;j++;
            }
            //if *, go back to match p[j-1]
            else if(p.charAt(j)=='*'){
                //if there's ".*", all char afterwards matches
                if(p.charAt(j-1) == '.') return true;
                if(p.charAt(j-1)>='a'&&p.charAt(j-1)<='z'){
                    if(s.charAt(i) == p.charAt(j-1)){
                        i++;
                    }
                    else j++;
                }
            }
        }
        if(j>p.length()-2) return true;
        else return false;
    }
}
