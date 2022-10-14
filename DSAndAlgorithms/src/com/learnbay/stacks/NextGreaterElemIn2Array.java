package com.learnbay.stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElemIn2Array {
	
	
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int num1Size = nums1.length;
		int num2Size = nums2.length;
		for (int i = 0; i < num1Size; i++) {
			int j=0;
			boolean greaterFound = false;
			boolean found = false;
			while(j < num2Size) {
				if(nums2[j] == nums1[i]) {
					found = true;
					j++;
					continue;
				}

				if(found && nums2[j] > nums1[i]) {
					nums1[i] = nums2[j] ;
					greaterFound = true;
					break;
				}

				j++;
			}
			if(!greaterFound)
				nums1[i] = -1;
		}//for
		return nums1;
	}
	
	public int[] nextGreaterElementUsingMap(int[] nums1, int[] nums2) {
		int num1Size = nums1.length;
		int num2Size = nums2.length;
		//populate res arra with all -1 
		int[] res = new int[num1Size];
		//map contains all element of nums1 with key as number and value as index of element
		Map<Integer, Integer> num1Map = new HashMap<>();
		for (int i = 0; i < num1Size; i++) {
			num1Map.put(nums1[i], i);
			res[i] = -1;
		}
		
		for (int i = 0; i < num2Size; i++) {
			//if it contains in nums1 then check the next greater element from that number
			if(num1Map.containsKey(nums2[i])) {
				for (int j = i+1; j < num2Size-1; j++) {
					if(nums2[j] > nums2[i]) {
						res[num1Map.get(nums2[i])] = nums2[j];
						break;
					}
				}
			}
		}
		return res;
	}
	
	public int[] nextGreaterElementUsingStack(int[] nums1, int[] nums2) {
		int num1Size = nums1.length;
		int num2Size = nums2.length;
		//populate res arra with all -1 
		int[] res = new int[num1Size];
		//map contains all element of nums1 with key as number and value as index of element
		Map<Integer, Integer> num1Map = new HashMap<>();
		for (int i = 0; i < num1Size; i++) {
			num1Map.put(nums1[i], i);
			res[i] = -1;
		}
		
		//Stack stores all the element present in nums1 array and if the element from nums2 
		//is greater than the the element from nums2, pop the element and store it in res at nums1 index
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < num2Size; i++) {
			while(!s.isEmpty() && nums2[i] > s.peek()) {
				int popElem = s.pop();
				res[num1Map.get(popElem)] = nums2[i];
			}

			if(num1Map.containsKey(nums2[i])) {
				s.push(nums2[i]);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		NextGreaterElemIn2Array n = new NextGreaterElemIn2Array();
		//int[] n1 = {2,4};//{4, 1, 2 };
		//int[] n2 = {1,2,3,4};//{1, 3, 4, 2};
		
		int[] n1 = {4, 1, 2 };
		int[] n2 = {1, 3, 4, 2};
		//System.out.println("nextGreaterElement:" +Arrays.toString(n.nextGreaterElement(n1, n2)));
		//System.out.println("nextGreaterElement:" +Arrays.toString(n.nextGreaterElementUsingMap(n1, n2)));
		System.out.println("nextGreaterElement:" +Arrays.toString(n.nextGreaterElementUsingStack(n1, n2)));
	}

}
