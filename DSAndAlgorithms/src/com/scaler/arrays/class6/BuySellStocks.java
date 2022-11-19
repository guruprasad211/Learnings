package com.scaler.arrays.class6;

/*
 * Say you have an array, A, for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.

Return the maximum possible profit.

To sell the stock we have to buy and to get max profit buy at low price and sell at max price
1 , 2   if we 

find the minPrice to its left elem to sell the stock at ith day and calculate the max profit at every day
store min price while we move to right
store max profit while we move to right
 */
public class BuySellStocks {
    public static int maxProfit(final int[] A) {
        int size = A.length;

        if (size == 0 || size == 1) {
            return 0;
        }
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = A[0];
        for (int i = 1; i < size; i++) {
            //calculate min price to its left of the element 
            minPrice = Math.min(minPrice, A[i - 1]);
            //nax profit
            maxProfit = Math.max(maxProfit, A[i] - minPrice);
        }
        return maxProfit < 0 ? 0 : maxProfit;
    }

    public static void main(String[] args) {
        //int[] a = {1, 2};
        int[] a = { 1, 4, 5, 2, 4 };
        System.out.println(maxProfit(a));
    }

}
