/*bobble sort */

import java.util.*;

public class pratical2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size, type, temp;
        int a[] = new int[1000];
        int i, j;

        System.out.print("Enter the size of array: ");
        size = sc.nextInt();

        for (int i1 = 0; i1 < size; i1++) {
            a[i1] = (int) (Math.random() * 100);
        }

        long t1 = System.nanoTime();

        for (i = 0; i < size - 1; i++) {

            for (j = 0; j < size - i - 1; j++) {

                if (a[j] > a[j + 1]) {

                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }

            System.out.println("Stage of array after " + (i + 1) + " step:");

            for (int k = 0; k < size; k++) {
                System.out.print(a[k] + " ");
            }

            System.out.println(" ");
        }

        long t2 = System.nanoTime();

        System.out.println("\nYour Sorted array:\n");

        for (i = 0; i < size; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println("\nTotal time taken by the system to sort the array is "
                + (t2 - t1) + " nanosecond.");
    }
}