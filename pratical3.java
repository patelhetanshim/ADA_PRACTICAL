/* insertion sort */

import java.util.*;

public class pratical3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a[] = new int[1000];
        int size, i, j, temp;

        System.out.print("Enter the size of array: ");
        size = sc.nextInt();

        // Random array generation
        for (i = 0; i < size; i++) {
            a[i] = (int)(Math.random() * 100);
        }

        long t1 = System.nanoTime();

        // Insertion Sort
        for (i = 1; i < size; i++) {
            temp = a[i];
            j = i - 1;

            while (j >= 0 && a[j] > temp) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = temp;

            // Print phase after each step
            System.out.println("Stage of array after " + i + " step:");
            for (int k = 0; k < size; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println();
        }

        long t2 = System.nanoTime();

        System.out.println("\nYour Sorted Array:");
        for (i = 0; i < size; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println("\nTotal time taken by the system to sort the array is "
                + (t2 - t1) + " nanosecond.");
    }
}