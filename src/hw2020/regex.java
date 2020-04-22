package hw2020;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {

    public static void main(String[]args){
        String regex = "[A-Z]{1,1}[^A-Z]+";
        //String regex = "[A-Z]+?[a-z0-9]*";
        String s = "TomMaryJaneJackIanaPPPino";
        Pattern mp = Pattern.compile(regex);
        Matcher mm = mp.matcher(s);
        while(mm.find()){
            System.out.println(mm.group());
        }
    }
}
