

/* merge sort */
import java.util.*;

public class Practical4 {

    static void merge(int a[], int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = a[l + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = a[m + 1 + j];
        }

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k++] = L[i++];
            } else {
                a[k++] = R[j++];
            }
        }

        while (i < n1) {
            a[k++] = L[i++];
        }

        while (j < n2) {
            a[k++] = R[j++];
        }
    }

    static void mergeSort(int a[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size;
        int a[] = new int[100];

        System.out.print("Enter the size of array: ");
        size = sc.nextInt();

        for (int i = 0; i < size; i++) {
            a[i] = (int) (Math.random() * 100);
        }

        long t1 = System.nanoTime();

        mergeSort(a, 0, size - 1);

        long t2 = System.nanoTime();

        System.out.println("Sorted array:");

        for (int i = 0; i < size; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println("\nTotal time taken by the system to sort the array is "
                + (t2 - t1) + " nanosecond.");
    }
}