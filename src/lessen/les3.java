package lessen;

import java.util.Arrays;

/**
 * Created by thom on 9-9-2016.
 */
public class les3 {
    public static void main(String[] args) {
        int[] unsortedList = {8,6,0,7,5,3,1};
        System.out.println("----- insertion sort -----");
        System.out.println(Arrays.toString(insertionSort2(unsortedList)));
        System.out.println("----- merge sort -----");
        unsortedList = new int[]{8,6,0,7,5,3,1};
        int[] mergeSort = sort(unsortedList,true);
        System.out.println("----- quick sort -----");
//        int[] quickSort = quickSort(unsortedList);
        unsortedList = new int[]{8,6,0,7,5,3,1};
        sort2(unsortedList);
        for(int i:unsortedList){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("\n----- quick sort2 -----");
        Integer[] unsortedList2 = new Integer[]{8,6,0,7,5,3,1};
        System.out.println(Arrays.toString(quickSort(unsortedList2,0,unsortedList2.length)));


    }

    /**
     * insertion sort
     * @param unsortedArray
     * @return
     */
    public static int[] insertionSort(int[] unsortedArray){
        for( int i = 1; i < unsortedArray.length; i++ ){
            int tmp = unsortedArray[ i ];
            int j = i;
            while(j > 0 && tmp < unsortedArray [j-1]){
                unsortedArray[ j ] = unsortedArray[ j - 1 ];
                j--;
            }
            unsortedArray[ j ] = tmp;
        }
        return unsortedArray;
    }

    public static int[] insertionSort2(int[] unsortedArray){
        for(int i = 1; i < unsortedArray.length; i++) {
            int tempNumber = unsortedArray[i];
            for(int j = i-1; j >= 0 && unsortedArray[j] > tempNumber; j--) {
                    unsortedArray[j+1] = unsortedArray[j];
                    unsortedArray[j] = tempNumber;
//                    System.out.println(Arrays.toString(unsortedArray));
            }
        }
        return unsortedArray;
    }


    public static int[] quickSort(int[] unsortedArray) {
        int[] pivotChanges = {unsortedArray[0],unsortedArray[unsortedArray.length/2], unsortedArray[unsortedArray.length-1]};
        int pivot = median(pivotChanges);
        System.out.println("pivot: " + pivot);

        return null;
    }
    
    public static int median(int [] medianCheck) {
        if (medianCheck[0] > medianCheck[1]) {
            if (medianCheck[1] > medianCheck[2]) {
                return medianCheck[1];
            } else if (medianCheck[0] > medianCheck[2]) {
                return medianCheck[2];
            } else {
                return medianCheck[0];
            }
        } else {
            if (medianCheck[0] > medianCheck[2]) {
                return medianCheck[0];
            } else if (medianCheck[1] > medianCheck[2]) {
                return medianCheck[2];
            } else {
                return medianCheck[1];
            }
        }
    }


    public static int[] sort(int[] arr, boolean showSteps) {
        int number = arr.length;
        int[] helpers = new int[number];
        mergesort(0, number - 1, arr, helpers,showSteps);
        return arr;
    }

    private static void mergesort(int low, int high, int[] arr, int[] helpers, boolean showSteps) {
        // check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle, arr, helpers, showSteps);
            // Sort the right side of the array
            mergesort(middle + 1, high, arr, helpers, showSteps);
            // Combine them both
            merge(low, middle, high, arr,helpers, showSteps);
            if(showSteps) {
                System.out.println(Arrays.toString(arr));
            }
        }
    }

    private static void merge(int low, int middle, int high, int[] numbers, int[] helpers, boolean showSteps) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helpers[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helpers[i] <= helpers[j]) {
                numbers[k] = helpers[i];
                i++;
            } else {
                numbers[k] = helpers[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helpers[i];
            k++;
            i++;
        }
    }

    private static int array[];

    public static void sort2(int[] inputArr) {

        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        array = inputArr;
        int length = inputArr.length;
        quickSort(0, length - 1);
    }

    private static void quickSort(int lowerIndex, int higherIndex) {
        System.out.println(Arrays.toString(array));
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
//        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        int pivot = median(new int[]{array[lowerIndex],array[higherIndex],array[(higherIndex-lowerIndex)/2]});
        System.out.println("pivot: " + pivot + " array to check: ");
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }

    private static void swap(int lowest, int highest) {
        System.out.println("swap: " + array[lowest] + " - " + array[highest]);
        int temp = array[lowest];
        array[lowest] = array[highest];
        array[highest] = temp;
    }

    public static int getMedianIndex(int[][] arr) {
        if (arr[0][1] > arr[1][1]) {
            if (arr[1][1] > arr[2][1]) {
                return arr[1][0];
            } else if (arr[0][1] > arr[2][1]) {
                return arr[2][0];
            } else {
                return arr[0][0];
            }
        } else {
            if (arr[0][1] > arr[2][1]) {
                return arr[0][0];
            } else if (arr[1][1] > arr[2][1]) {
                return arr[2][0];
            } else {
                return arr[1][0];
            }
        }
    }

    public static Integer[] quickSort(Integer[] inputArray, int startingIndex, int endingIndex){
        if(endingIndex<=startingIndex || startingIndex>=endingIndex){}

        else{
            int leftPointer = startingIndex;
            int rightPointer = endingIndex-1;
            int pivotIndex =  getMedianIndex(new int[][] {{startingIndex,inputArray[startingIndex]},{endingIndex/2,inputArray[endingIndex/2]},{endingIndex-1,inputArray[endingIndex-1]}});
            int pivot = inputArray[pivotIndex];
            while(leftPointer <= rightPointer && (pivotIndex > leftPointer || pivotIndex < rightPointer)) {
                boolean swapLeft = false;
                boolean swapRight = false;
                if(inputArray[leftPointer] > pivot) {
                    swapLeft = true;
                }
                if (inputArray[rightPointer] < pivot) {
                    swapRight = true;
                }
                if(swapLeft && swapRight) {
                    int temp = inputArray[leftPointer];
                    inputArray[leftPointer] = inputArray[rightPointer];
                    inputArray[rightPointer] = temp;
                }
                if(!swapRight && inputArray[leftPointer] > pivot) {
                    inputArray[pivotIndex] = inputArray[leftPointer];
                    inputArray[leftPointer] = pivot;
                    pivotIndex = leftPointer;
                    pivot = inputArray[pivotIndex];
                }
                if(!swapLeft && inputArray[rightPointer] < pivot) {
                    inputArray[pivotIndex] = inputArray[rightPointer];
                    inputArray[rightPointer] = pivot;
                    pivotIndex = rightPointer;
                    pivot = inputArray[pivotIndex];
                }
                if(leftPointer < pivotIndex) {
                    leftPointer++;
                }
                if(rightPointer > pivotIndex) {
                    rightPointer--;
                }
//                System.out.println(Arrays.toString(inputArray));
            }
            if(pivotIndex > startingIndex + 1) {
                quickSort(inputArray, startingIndex, pivotIndex);
            }
            if(pivotIndex+1 != inputArray.length) {
                quickSort(inputArray, pivotIndex + 1, endingIndex);
            }
        }
        return inputArray;
    }


}
