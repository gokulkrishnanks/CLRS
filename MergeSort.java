/**
 * Created by gokul on 2/11/16.
 */
import java.util.Arrays;
import java.util.Scanner;
public class MergeSort {
    private static void merge(int[] a, int p, int q, int r) {
        int n1 = q - p +1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for(int i = 0; i < n1; i++) L[i] = a[p + i];
        for(int j = 0; j < n2; j++) R[j] = a[q + j + 1];
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for(int k = p; k <= r; k++) {
            if(L[i] <= R[j]){
                a[k] = L[i];
                i++;
            }
            else {
                a[k] = R[j];
                j++;
            }
        }
    }

    private static void merge_sort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(a, p, q);
            merge_sort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    public  static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numEl;
        System.out.println("Merge Sort:");
        System.out.print("Enter the size of the array:");
        numEl = in.nextInt();

        //Declaring array of specified size
        int[] a = new int[numEl];

        //Generating random array
        for(int i = 0; i <  numEl; i++) a[i] = (int)(Math.random() * 100);

        System.out.print("Unsorted array: ");
        System.out.println(Arrays.toString(a));

        int p = 0,r = numEl-1;
        System.out.print("Sorted Array: ");

        //Calling the sorting method
        merge_sort(a, p, r);
        System.out.println(Arrays.toString(a));

    }
}
