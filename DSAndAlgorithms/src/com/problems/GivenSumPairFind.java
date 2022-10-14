package com.problems;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find Pair of elements for a given sum
 * @author guruprasadchowdaryp
 *
 */
public class GivenSumPairFind {
	
	public static void findPair(int sum, Integer[] arr) {
		int n=arr.length;
		//O(n2)
		/*for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i] + arr[j] == sum) {
					System.out.println("pair found:" +arr[i] + " and "+ arr[j]);
				}
			}
		}*/
		
		//O(nlogn), as sorting is involved
		/*int l=0;
		int r = n-1;
		List<Integer> list = Arrays.asList(arr);
		Collections.sort(list);
		while(l<r) {
			if(list.get(l) + list.get(r) == sum) {
				System.out.println("pair found:" +list.get(l) + " and "+ list.get(r));
			}
			if(list.get(l) + list.get(r) < sum) {
				l++;
			}
			else {
				r--;
			}
		}*/
		
		//O(n) - time & O(n) - space
		Map<Integer, Boolean> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			int remainEl=sum-arr[i];
			if(map.containsKey(remainEl)) {
				System.out.println("pair found:" +arr[i] + " and "+ remainEl);
			}
			map.put(arr[i], true);
		}
		
	}
	
	public static void main(String[] args) {
		Integer[] arr = {5,6,7,8,9,4,5,15,-5};
		findPair(10,arr);
	}

}
