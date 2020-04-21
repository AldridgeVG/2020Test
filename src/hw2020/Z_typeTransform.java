package hw2020;

public class Z_typeTransform {

    public static void main(String[] args) {
        String s = convert("PAYPALISHIRING", 3);
        System.out.println(s);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 0) return null;
        if (numRows == 1) return s;
        int Len = s.length();

        int setLen = numRows * 2 - 2;

        int setNum = Len / setLen;
        int remainNum = Len % setLen;
        int lines = numRows;
        int rows = (setNum + 1) * (numRows - 1);
        char[][] chs = new char[lines][rows];
        //init
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < rows; j++) {
                chs[i][j] = ' ';
            }
        }
        int curRow = 0;
        //get setNum subs of s
        for (int i = 0; i < setNum; i++) {
            String cur = s.substring(i * setLen, (i + 1) * setLen);
            curRow = i * (numRows - 1);
            for (int j = 0; j < lines; j++) {
                chs[j][curRow] = cur.charAt(j);
            }
            for (int j = 1; j <= numRows - 2; j++) {
                chs[lines - j-1][curRow + j] = cur.charAt(numRows + j - 1);
            }
        }
        //deal with the rest
        if (remainNum != 0) {
            String rest = s.substring(setNum * setLen);
            int len = rest.length();
            curRow = (setNum) * (lines - 1);
            if (len <= lines) {
                for (int i = 0; i < len; i++) {
                    chs[i][curRow] = rest.charAt(i);
                }
            } else {
                int restNum = len - lines;
                for (int i = 0; i < lines; i++) {
                    chs[i][curRow] = rest.charAt(i);
                }
                for (int i = 1; i <= restNum; i++) {
                    chs[lines - i-1][curRow + i] = rest.charAt(lines + i - 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < rows; j++) {
                //if(chs[i][j]!=' '){
                sb.append(chs[i][j] + "");
                //}
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
