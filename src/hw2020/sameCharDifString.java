package hw2020;

public class sameCharDifString {

    public static void main(String[]args){
        System.out.println(isAnagram("nigger","ggenir"));
    }

    public static boolean isAnagram(String s, String t) {
        int ls = s.length();
        int ts = t.length();
        if(ls!=ts) return false;
        int a[] = new int[26];
        int index;
        //scan s
        for(int i=0;i<ls;i++){
            index = s.charAt(i) - 'a';
            a[index]++;
        }
        //scan t
        for(int i=0;i<ls;i++){
            index = t.charAt(i) - 'a';
            a[index]--;
        }
        //check arr
        for(int i=0;i<26;i++){
            if(a[i] != 0) return false;
        }
        return true;
    }

}
