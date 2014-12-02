/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duck_of_doom;

/**
 * Makes a min heap. Uses that to sort the data provided.
 * @author markham
 */
public class HeapSorter extends Sorter {
 
    private final int[] heap; // a min heap that holds the data to sort
    private final int[] input;
    private int length; // number of items in the heap
    
    /**
     * @param  input an array which shall be overwritten (sorted) by the sort() function
     */
    public HeapSorter(int[] input) {
        length = 0;
        this.input = input;
        heap = new int[input.length];
        for (int i = 0; i < input.length; i++)
            push(input[i]);
    }
    
    /**
     * Overwrites input array with sorted data, popped from the heap.
     * @return the input array, now sorted.
     */
    @Override
    public int[] sort() {
        for (int i = 0; i < input.length; i++)
            input[i] = pop();
        return input;
    }
    
    /**
     * @param idx Index of a parent
     * @return Index of left child of argument `idx`
     */
    private static int leftChildIndexOf(int idx) {
        return idx * 2 + 1;
    }
    
    /**
     * Recursively swap positions of item and one of its children until the lineage is in order, with the smallest value at the top.
     * @param idx 
     */
    private void swapChildIfLarger(int idx) {
        int leftChildI = leftChildIndexOf(idx);
        int rightChildI = leftChildI + 1;
        int swapChildI = idx;
        if (leftChildI < length && heap[idx] > heap[leftChildI])
            swapChildI = leftChildI;
        else if (rightChildI < length && heap[idx] > heap[rightChildI])
            swapChildI = rightChildI;
        if (swapChildI > idx) {
            int holder = heap[idx];
            heap[idx] = heap[swapChildI];
            heap[swapChildI] = holder;
            swapChildIfLarger(swapChildI);
        }
    }
    
    /**
     * Recursively swap positions of item and its parent until the lineage is in order, with the smallest value at the top
     * @param idx 
     */
    private void swapParentIfSmaller(int idx) {
        int parentIdx = parentIndexOf(idx);
        if (parentIdx >= 0 && heap[idx] < heap[parentIdx]) {
            int holder = heap[idx];
            heap[idx] = heap[parentIdx];
            heap[parentIdx] = holder;
            swapParentIfSmaller(parentIdx);
        }
    }
    
    private static int parentIndexOf(int idx) {
        return (idx - 1) / 2;
    }
    
    /**
     * Pop the heap root and restore the heap structure.
     */
    private int pop() {
        int output = heap[0];
        length -= 1;
        if (length > 0) {
            heap[0] = heap[length];
            swapChildIfLarger(0);
        }
        return output;
    }
    
    private void push(int i) {
        heap[length] = i;
        length += 1;
        if (length > 1) {
            swapParentIfSmaller(length-1);
        }
    }
    
}
