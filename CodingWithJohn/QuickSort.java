package com.coding.with.john.sorting;

import java.util.Random;

/**
 * This is the fastest sorting Algorithm
 * Steps:
 *  1. Choose an element in an array as pivot element (here we have taken last element)
 *  2. Arrange all elements lower than pivot to left and greater than pivot to Right which is called partition
 *      2a. Take 2 pointers lp start of the array and rp as length-2 other than pivot element
 *      2b. move the lp until the greater element found than the pivot
 *      2c. Move the right pointer until the lesser element than the pivot is found
 *      2d. Swap the elements from lp and rp
 *      2e. repeat steps until lp==rp
 *      2d. swap pivot element with the step 2e (Now all the elements left to pivot are smaller and to right are greater)
 *  3. Recursively quick sort elements lower than the pivot except pivot element and right side element which are greater than pivot
 *  4. Recursively sort the element until one element to left/right of the array
 * 
 * @author guruprasadchowdaryp
 *
 */
public class QuickSort {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        printArray(numbers);

        quicksort(numbers);

        System.out.println("\nAfter:");
        printArray(numbers);
    }

    //caller calls simple quickSort, in this we call other sort
    private static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int lowIndex, int highIndex) {
        System.out.println("lowIndex:"+lowIndex + " highIndex:"+highIndex);
        //If there is only one element to sort at left or right side of the pivot stop it
        if (lowIndex >= highIndex) {
            return;
        }

        //int pivot = array[highIndex]
        
        //instead of choosing always the last index choose some random number, which increases the performance
        //randomly choose the pivot element and swap the pivotIndex to the last index of the array
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

        int leftPointer = partition(array, lowIndex, highIndex, pivot);

        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, highIndex);

    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while (leftPointer < rightPointer) {

            // Walk from the left until we find a number greater than the pivot and up to the right pointer.
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            // Walk from the right until we find a number less than the pivot, and hit the left pointer.
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            //swap the lp and rp elements
            swap(array, leftPointer, rightPointer);
        }

        // This is different from what the video has, and fixes an issue where the last value could potentially be out of order. 
        // Thanks to viewer Wilson Barbosa for suggesting the fix!
        //to swap pivot and rp=lp element to move all the elements greater than pivot to right of pivot
        //at first we considered right elements without pivot element
        if (array[leftPointer] > array[highIndex]) {
            swap(array, leftPointer, highIndex);
        }
        else {
            leftPointer = highIndex;
        }
        //return lp so that to recursively iterate the elements to left and right of the pivot
        return leftPointer;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}