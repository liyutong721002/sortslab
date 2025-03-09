package edu.grinnell.csc207.sortslab;

/**
 * A collection of sorting algorithms over generic arrays.
 */
public class Sorts {

    public static int binarySearch(int value, int arr[], int lo, int hi) {
        int mid = lo + (hi - lo) / 2; //because it might overflow the data; biggest int value is 2^31 - 1
        while (arr[mid] != value && lo < hi) {
            if (arr[mid] < value) {
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
     * Swaps indices <code>i</code> and <code>j</code> of array
     * <code>arr</code>.
     *
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
     *
     * @param <T>
     * @param arr
     * @param bound The higher bound which the comparison should be done.
     * @return the index of the largest element
     */
    public static <T extends Comparable<? super T>> int findMax(T[] arr, int bound) {
        int max = 0;
        for (int n = 1; n < bound; n++) {
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
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void bubbleSort(T[] arr) {
        for (int n = arr.length - 1; n > 0; n--) {
            for (int m = 0; m < n; m++) {
                if (arr[m].compareTo(arr[m + 1]) > 0) {
                    swap(arr, m, m + 1);
                }
            }
        }
    }

    /**
     * Sorts the array according to the selection sort algorithm:
     * <pre>
     * [ i smallest elements in order | unprocessed ]
     * </pre>
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] arr) {
        for (int m = 0; m < arr.length - 1; m++) {
            int min = m;
            for (int n = m + 1; n < arr.length; n++) {
                if (arr[n].compareTo(arr[min]) < 0) {
                    min = n;
                }
            }
            swap(arr, m, min);
        }
    }

    /**
     * Sorts the array according to the insertion sort algorithm:
     * <pre>
     * [ i elements in order | unprocessed ]
     * </pre>
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
        for (int n = 1; n < arr.length; n++) {
            int index = n;
            for (int m = n - 1; m >= 0; m--) {
                if (arr[m].compareTo(arr[index]) > 0) {
                    swap(arr, m, index);
                    index = m;
                }
            }
        }
    }

    /**
     *
     * @param <T> the carrier type of the array
     * @param arr1 the array to merge
     * @param arr2 the array to merge (we assume both arr1 and arr2 are sorted
     * from the smallest to the largest
     * @return
     */
    public static <T extends Comparable<? super T>> T[] merge(T[] arr1, T[] arr2) {
        T[] result = (T[]) new Comparable[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i].compareTo(arr2[j]) <= 0) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        return result;
    }

    /**
     * Sorts the array according to the merge sort algorithm:
     * <pre>
     * [ sorted | sorted ] -> [ sorted ]
     * </pre>
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            T[] left = (T[]) new Comparable[mid];
            T[] right = (T[]) new Comparable[arr.length - mid];
            System.arraycopy(arr, 0, left, 0, mid);
            System.arraycopy(arr, mid, right, 0, arr.length - mid);
            mergeSort(left);
            mergeSort(right);
            T[] merged = merge(left, right);
            System.arraycopy(merged, 0, arr, 0, merged.length);
        }
    }

    public static <T extends Comparable<? super T>> int partition(T[] arr) {
        int i = -1;
        int j = 0;
        T pivot = arr[arr.length - 1];
        while (j < arr.length - 1) {

            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
                j++;
            } else {
                j++;
            }
        }
        swap(arr, i + 1, arr.length - 1);
        return i + 1;
    }

    /**
     * Sorts the array according to the quick sort algorithm:
     * <pre>
     * []
     * </pre>
     *
     * @param <T>
     * @param arr
     */
    public static <T extends Comparable<? super T>> void quickSort(T[] arr) {
        if (arr.length > 1) {
            int pivot = partition(arr);
            T[] left = (T[]) new Comparable[pivot];
            T[] right = (T[]) new Comparable[arr.length - pivot - 1];
            System.arraycopy(arr, 0, left, 0, pivot);
            System.arraycopy(arr, pivot + 1, right, 0, arr.length - pivot - 1);
            quickSort(left);
            quickSort(right);
            System.arraycopy(left, 0, arr, 0, left.length);
            System.arraycopy(right, 0, arr, pivot + 1, right.length);
        }
    }
}
