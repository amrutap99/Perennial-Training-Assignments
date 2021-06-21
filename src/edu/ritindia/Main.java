package edu.ritindia;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //here first element is choosen as pivot
        // int[] a = {2,6,1,8,4};
        // int n = a.length;

        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements you want to store: ");
        // reading the number of elements from the that we want to enter
        n = sc.nextInt();
        // creates an array in the memory of length 10
        int[] a = new int[10];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            // reading array elements from the user
            a[i] = sc.nextInt();
        }

        quickSort(a, 0, n - 1);
        printSortedArray(a, n);
    }

    private static void quickSort(int[] a, int lb, int ub) {
        int loc;
        if (lb < ub) {
            loc = partition(a, lb, ub);
            System.out.println("loc = " + loc); // loc is position of sorted pivot element
            quickSort(a, lb, loc - 1);
            quickSort(a, loc + 1, ub);
        }

    }

    private static int partition(int[] a, int lb, int ub) {
        int pivot = a[lb], start = lb, end = ub;

        while (start < end) {
            System.out.println("a[start] = " + a[start] + " , " + " pivot = " + pivot);
            while (a[start] <= pivot) {
                // while current element is less than pivot,increment start
                start++;
                System.out.println("start = " + start);
            }
            System.out.println("a[end] = " + a[end] + " , " + " pivot = " + pivot);
            while (a[end] > pivot) {
                end--;
                System.out.println("end = " + end);

            }

            // till here we will get some value index for start and end...now compare as
            // below
            if (start < end) {
                // swap start and end

                swap(a, start, end);

            }
        }
        // after while condition fails that is start has crossed end (start > end)..swap pivot element with end
        swap(a, lb, end);
        System.out.println("end = " + end);
        return end;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void printSortedArray(int[] a, int n) {
        System.out.println("Sorted Array :");
        for (int i = 0; i < n; i++) {

            System.out.println(a[i]);
        }
    }
}
