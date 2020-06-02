package hw2020;

public class HeapSort {

    public static void Swap(int A[], int l, int r) {
        int temp = A[l];
        A[l] = A[r];
        A[r] = temp;
    }

    public static void Heapify(int A[], int last) {
        for (int i = last; i >= 1; i--) {
            for (int j = i; j > 0; j--) {
                int parent = (j - 1) / 2;
                if (A[j] > A[parent]) Swap(A, j, parent);
            }
        }
    }

    public static void Hsort(int A[]) {
        int length = A.length;
        if (length <= 1) return;
        Heapify(A, length - 1);
        while (length >= 2) {
            Swap(A, 0, length - 1);
            Heapify(A, length - 2);
            length--;
        }
    }

    public static void main(String[] args) {
        int A[] = new int[]{3, 5, 1, 4, 6, 7, 3, 2, 1, 9, 0, 6, -22, -1, 5};
        Hsort(A);
        int i = A.length;
        int l = i;
        while (i > 0) {
            System.out.print(A[l - i]+", ");
            i--;
        }
    }
}
