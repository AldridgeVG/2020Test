package hw2020;

public class reverseInt {

    public static void main(String[] args) {
        System.out.println(reverse(-1234));
    }

    public static int reverse(int x) {
        if (x == 0) return 0;
        int[] bits = new int[12];
        int maxint = Integer.MAX_VALUE;
        int minint = Integer.MIN_VALUE;

        if (x == minint) return 0;

        for (int i = 0; i < 12; i++) bits[i] = 0;

        long reversed = 0;
        int v = x > 0 ? x : -x;
        int i = 0;
        while (v != 0) {
            bits[i] = v % 10;
            v = v / 10;
            i++;
        }
        int j = 0;
        while (j < i) {
            reversed += bits[j];
            reversed *= 10;
            j++;
        }
        reversed = reversed / 10;

        if (x > 0 && reversed > maxint) return 0;
        if (x < 0) {
            if (reversed - 1 > maxint) return 0;
        }
        return (int) reversed;
    }
}
