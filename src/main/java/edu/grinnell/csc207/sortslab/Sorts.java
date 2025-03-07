package edu.grinnell.csc207.sortslab;

/**
 * A collection of sorting algorithms over generic arrays.
 */
public class Sorts {
    
    public static int binarySearch(int value, int arr[], int lo, int hi){
        int mid = lo + (hi - lo) / 2; //because it might overflow the data; biggest int value is 2^31 - 1
        while (arr[mid] != value && lo < hi) {
            if (arr[mid] < value){
                lo = mid;
            } else if (arr[mid] > value) {
                hi = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * Swaps indices <code>i</code> and <code>j</code> of array <code>arr</code>.
     * @param <T> the carrier type of the array
     * @param arr the array to swap
     * @param i the first index to swap
     * @param j the second index to swap
     */
    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    /**
     * Find the largest element in the array.
     * @param <T>
     * @param arr
     * @param bound The higher bound which the comparison should be done.
     * @return the index of the largest element
     */
    public static <T extends Comparable<? super T>> int findMax(T[] arr, int bound) {
        int max = 0;
        for (int n  = 1; n < bound; n++) {
            if (arr[n].compareTo(arr[max]) > 0) {
                max = n;
            }
        }
        return max;
    }
    
    /**
     * Sorts the array according to the bubble sort algorithm:
     * <pre>
     * [ unprocessed | i largest elements in order ]
     * </pre>
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void bubbleSort(T[] arr) {
        int index = 0;
        boolean moreSwap = false;
        while (!moreSwap){
            while (arr[index].compareTo(arr[index + 1]) > 0 && index < arr.length - 1){
                swap(arr, index, index + 1);
                index++;
                moreSwap = true;
            }
            if (arr[index].compareTo(arr[index + 1]) <= 0 && index < arr.length - 1){
                index = index + 1;
                moreSwap = false;
            }else if (index >= arr.length - 1){
                index = 0;
                moreSwap = false;
            }
        }
        
//            for (int n = 0; n < arr.length;n++) {
//                for (int m = n; n <)
//                if (arr[n].compareTo(arr[n + 1]) > 0) {
//                
//            }
//            rounds--;
//        }
    }

    /**
     * Sorts the array according to the selection sort algorithm:
     * <pre>
     * [ i smallest elements in order | unprocessed ]
     * </pre>
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] arr) {
        
    }

    /**
     * Sorts the array according to the insertion sort algorithm:
     * <pre>
     * [ i elements in order | unprocessed ] 
     * </pre>
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
        // TODO: fill me in!
    }

    /**
     * Sorts the array according to the merge sort algorithm:
     * <pre>
     * [ sorted | sorted ] -> [ sorted ]
     * </pre>
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
        // TODO: fill me in!
    }

    /**
     * Sorts the array according to the quick sort algorithm:
     * <pre>
     * []
     * </pre>
     * @param <T>
     * @param arr
     */
    public static <T extends Comparable<? super T>> void quickSort(T[] arr) {
        // TODO: fill me in!
    }
}
