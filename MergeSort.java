/**
 * Merge Sort algorithm based on the work of Andrei Ciobanu
 * https://www.andreinc.net/2010/12/22/the-merge-sort-algorithm-implementation-in-java
 * 
 */

public class MergeSort {

    public static void main(String[] args) {

        // Array Declaration
        int[] array = new int[] { 95, 36, 2, 14, 85 };// ,75,45,63,97};

        // print unsorted array

        System.out.println("The unsorted array:");
        printArray(array);

        System.out.println();

        // How long is the array???
        int length = array.length;
        System.out.println("The length of the array is: " + length);

        // Calling the merge sort function
        // Parameters:
        // 0:array to be sorted
        // 1:initial index
        // 2:last index, calculated from lenght -1
        mergeSort(array, 0, length - 1);

        System.out.println("The sorted array:");
        printArray(array);
    }

    // Function to print the arrays
    public static void printArray(int[] array) {

        System.out.print("{ ");
        for (int i : array) {
            System.out.printf("%d ", i);

        }
        System.out.print("}");
    }

    // recursive function to divide the array
    public static void mergeSort(int[] array, int initIndex, int finalIndex) {

        if (initIndex < finalIndex) {
            int middle = (initIndex + finalIndex) / 2;
            mergeSort(array, initIndex, middle);
            mergeSort(array, middle + 1, finalIndex);
            merge(array, initIndex, middle, finalIndex);
        }

    }

    // Function to merge and sort the splits arrays
    public static void merge(int[] array, int initialV, int middleV, int finalV) {

        // helper arrays
        int leftArraySize = middleV - initialV + 1;
        int rightArraySize = finalV - middleV;

        int[] leftArray = new int[leftArraySize + 1]; // we are working with index, so add 1
        int[] rightArray = new int[rightArraySize + 1];

        /*
         * this part of the code insert the MAX_VALUE of an int at the end of the
         * helpers arrays
         */
        leftArray[leftArraySize] = Integer.MAX_VALUE;
        rightArray[rightArraySize] = Integer.MAX_VALUE;

        for (int i = 0; i < leftArraySize; i++) {
            leftArray[i] = array[initialV + i];
        }

        for (int i = 0; i < rightArraySize; i++) {
            rightArray[i] = array[i + middleV + 1];
        }

        // Here we make the sort over the preload arryas
        for (int l = 0, r = 0, j = initialV; j <= finalV; j++) {

            if (leftArray[l] <= rightArray[r]) {
                array[j] = leftArray[l];
                l++;
            } else {
                array[j] = rightArray[r];
                r++;
            }
        }
    }

}
