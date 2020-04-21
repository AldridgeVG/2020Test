package hw2020;

class longestPalindromeSubstring {

    public static void main(String[]args){
        String out = longestPalindrome("azwdzwmwcqzgcobeeiphemqbjtxzwkhiqpbrprocbppbxrnsxnwgikiaqutwpftbiinlnpyqstkiqzbggcsdzzjbrkfmhgtnbujzszxsycmvipjtktpebaafycngqasbbhxaeawwmkjcziybxowkaibqnndcjbsoehtamhspnidjylyisiaewmypfyiqtwlmejkpzlieolfdjnxntonnzfgcqlcfpoxcwqctalwrgwhvqvtrpwemxhirpgizjffqgntsmvzldpjfijdncexbwtxnmbnoykxshkqbounzrewkpqjxocvaufnhunsmsazgibxedtopnccriwcfzeomsrrangufkjfzipkmwfbmkarnyyrgdsooosgqlkzvorrrsaveuoxjeajvbdpgxlcrtqomliphnlehgrzgwujogxteyulphhuhwyoyvcxqatfkboahfqhjgujcaapoyqtsdqfwnijlkknuralezqmcryvkankszmzpgqutojoyzsnyfwsyeqqzrlhzbc");
        //String out = longestPalindrome("aaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaa");
        //String out = longestPalindrome("aaaabbbbaaaa");
        System.out.println(out);

    }

    public static String longestPalindrome(String s) {

        if(s.equals("")) return "";
        if(s.length() == 1) return s;
        if(s.length() == 2){
            if(s.charAt(0) == s.charAt(1)) return s;
            else return s.charAt(0)+"";
        }
        else{
            int len = s.length();
            int curl = 0;
            int maxl = 0;
            int left = 0;
            int right = 0;
            int curLeft = 0;
            int curRight = 0;
            for(int i = 1; i < len-1; i++){
                curLeft = i;
                curRight = i;
                //to left
                while(curLeft>=0 && s.charAt(curLeft) == s.charAt(i)){
                    curLeft--;
                }
                // or to right
                while(curRight<=len-1 && s.charAt(curRight) == s.charAt(i)){
                    curRight++;
                }
                //to left and right
                int l = curLeft;
                int r = curRight;
                while(l>=0 && r<=len-1){
                    if(s.charAt(l) == s.charAt(r)){
                        curLeft--;
                        curRight++;
                        l--;
                        r++;
                    }
                    else break;
                }
                /*
                //if just one side out of bound
                int flag = 1;
                if(r<=len-1 && l < 0){
                    l++;
                    while(l<=r){
                        if(s.charAt(l) == s.charAt(r)){
                            l++; r--;
                        }
                        else{
                            flag = 0;
                            break;
                        }
                    }
                    if(flag == 1) curRight++;
                }
                else if(l>=0 && r>len-1){
                    r--;
                    while(l<=r){
                        if(s.charAt(l) == s.charAt(r)){
                            l++; r--;
                        }
                        else{
                            flag = 0;
                            break;
                        }
                    }
                    if(flag == 1) curLeft--;
                }
                */

                curl = curRight - curLeft - 2;
                if(curl>maxl){
                    maxl = curl;
                    left = curLeft+1;
                    right = curRight-1;
                }
            }
            String ret = s.substring(left,right+1);
            return ret;
        }
    }
}