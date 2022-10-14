package com.problems;

import java.util.Arrays;

public class MaxMinRemove {
	
	public static long leftElement(long a[], long n) {
		Arrays.sort(a);
		boolean removeMax=true;
		int l=0;
		long r=n-1;
		long count=0;
		while(count!=n-1) {
			count++;
			if(removeMax) {
				r--;
				removeMax=false;
			}else {
				l++;
				removeMax=true;
			}
		}
		return a[l];
	}
	
	boolean arraySortedOrNot(int[] arr, int n) {
        for(int i=0;i<arr.length-1;i++) {
        	if(arr[i+1] > arr[i]) {
        		return false;
        	}
        }
        return true;
    }
	
	static boolean fascinating(String q) {
		long num=Long.parseLong(q);
        String s=q+(num*2)+(num*3);
        if(s.length() < 9) {
            return false;
        }
        System.out.println("s:"+s);
        //check if string contains 1 to 9
        for(int i=1;i<10;i++) {
        	if(s.indexOf(String.valueOf(i)) == -1)
        		return false;
        }
        return true;
    }
	
	public static int sumElement(int arr[], int n)
    {
		int sum=0;
        for(int a : arr) {
        	sum+=a;
        }
        return sum;
    }
	
	public static void rearrange(long arr[], int n){
		if(n==1) {
			return;
		}
        int l=0;
        int r=n-1;
        //Arrays.sort(arr);
        boolean max=true;
        long[] o = new long[n];
        int count=0;
        while(count < n) {
        	if(max){
        		o[count] = arr[r];
        		r--;
        		max=false;
        	} else {
        		o[count] = arr[l];
        		l++;
        		max=true;
        	}
        	count++;
        } 
    }

	public static void main(String[] args) {
		long[] a= {8, 1, 2, 9, 4, 3, 7, 5};
		System.out.println(""+leftElement(a, a.length));
		
		//System.out.println("is Fascinating: "+fascinating("879"));
		long[] arr = {1,2,3,4,5,6};
		
		rearrange(arr, arr.length);
		for(long e : arr) {
			System.out.print(e +" ");
		}

	}

}
