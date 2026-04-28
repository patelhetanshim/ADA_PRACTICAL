/* quick sort */

import java.util.*;

public class pratical5 {
    static int a[] = new int[1000];
    static int size;

    public static int partition(int low, int high) {
        int pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;
    }

    public static void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);

            
            System.out.println("Stage after partition at index " + pi + ":");
            for (int k = 0; k < size; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println();

            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        size = sc.nextInt();

        // Random array generation
        for (int i = 0; i < size; i++) {
            a[i] = (int)(Math.random() * 100);
        }

        long t1 = System.nanoTime();

        quickSort(0, size - 1);

        long t2 = System.nanoTime();

        System.out.println("\nYour Sorted Array:");
        for (int i = 0; i < size; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println("\nTotal time taken by the system to sort the array is "
                + (t2 - t1) + " nanosecond.");
    }
}
