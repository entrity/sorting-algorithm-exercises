/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duck_of_doom;

/**
 *
 * @author markham
 */
public abstract class Sorter {
    
    /**
     * Reference to input data, supplied to constructor. This shall be overwritten by the sort() function.
     */
    protected final int[] input;
    
    public Sorter(int[] input) {
        this.input = input;
    }
    
    /**
     * Sort data from input array and overwrite input array with sorted data.
     * @return input array, now sorted
     */
    public abstract int[] sort();
    
}
