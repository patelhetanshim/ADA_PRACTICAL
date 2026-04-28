/*selection sort */

import java.util.*;

public class pratical1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a[] = new int[1000];
        int size, i, j, temp, min;

        System.out.print("Enter the size of array: ");
        size = sc.nextInt();

        // Random array generation
        for (i = 0; i < size; i++) {
            a[i] = (int)(Math.random() * 100);
        }

        long t1 = System.nanoTime();

        // Selection Sort
        for (i = 0; i < size - 1; i++) {
            min = i;

            for (j = i + 1; j < size; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            temp = a[i];
            a[i] = a[min];
            a[min] = temp;

            // Print each phase
            System.out.println("Stage of array after " + (i + 1) + " step:");
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