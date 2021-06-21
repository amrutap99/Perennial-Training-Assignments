package edu.ritindia;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //int[] a = {2,6,1,8,4};

        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements you want to store: ");
        //reading the number of elements from the that we want to enter
        n = sc.nextInt();
        //creates an array in the memory of length 10
        int[] a = new int[10];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            //reading array elements from the user
            a[i] = sc.nextInt();
        }

        mergeSort(a, 0, n - 1);
        printSortedArray(a, n);
    }

    private static void mergeSort(int[] a, int lb, int up) {
        int mid;
        //System.out.println("Lower Bound = "+lb);
        // System.out.println("Upper Bound = "+up);
        if (lb < up) {
            mid = (lb + up) / 2;
            // System.out.println("Mid = "+mid);
            //System.out.println("Left division");
            mergeSort(a, lb, mid);               //recursive call for left side divided elements
            //  System.out.println("------------------------------------");
            // System.out.println("Right division");
            mergeSort(a, (mid + 1), up);          //recursive call for right side divided elements

            merge(a, lb, mid, up);              //when only single elements remain,after that sort and combine

        }

    }

    private static void merge(int[] a, int lb, int mid, int up) {

        int i = lb, j = mid + 1, k = lb;
        //System.out.println("i = "+i+" , j = "+j);
        int[] temp = new int[10];   //declaring empty array
        //final logic
        while ((i <= mid) && (j <= up)) {
            //System.out.println(a[i]+" , "+a[j]);
            if (a[i] <= a[j]) {
                temp[k] = a[i];
                i++;

            } else {
                temp[k] = a[j];
                j++;
            }
            k++;
        }

        if (i > mid) {       //if left side array elements get all sorted and placed in temp array
            // but right side elements still not placed in temp array, then just put those as it is in temp array(as those are already sorted)
            while (j <= up) {
                temp[k] = a[j];
                j++;
                k++;
            }
        } else {
            while (i <= mid) {
                temp[k] = a[i];
                i++;
                k++;
            }
        }

        //print all elements
        for (k = lb; k <= up; k++) {
            //System.out.println("temp[k] = "+temp[k]);

            a[k] = temp[k];
            //System.out.println("a[k] = "+a[k]);

        }


    }

    private static void printSortedArray(int[] a, int n) {
        System.out.println("Sorted Array :");
        for (int i = 0; i < n; i++) {

            System.out.println(a[i]);
        }
    }
}
