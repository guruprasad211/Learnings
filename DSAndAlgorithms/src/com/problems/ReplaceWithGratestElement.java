package com.problems;

/**
 * I/P:10,8,2,4,3,7,7,1
 * O/P: 8,7,7,7,7,7,1,-1
 * Replace each element with the gratest element on the right side, for last element replace with -1
 * @author guruprasadchowdaryp
 *
 */
public class ReplaceWithGratestElement {

	public static void main(String[] args) {
		//int[] el = {10,8,2,4,3,7,1};
		int[] el = {10,8};
		//O(n*n)
		/*for(int i=0;i<el.length;i++) {
			el[i] = findRightMaxElement(el,i+1);
		}*/
		//O(n)
		int n = el.length;
		if(n==1) {
			el[n-1] = -1;
			System.out.println("-1");
		}

		//el[n-2] = el[n-1];
		int max=el[n-1];
		el[n-1] = -1;
		for(int i=n-2;i>=0;i--) {
			int temp=el[i];
			el[i]=max;
			if(max<temp) {
				max=temp;
			}
		}
		for(int j:el) {
			System.out.print(j);
		}
	}

	private static Integer findRightMaxElement(int[] el, int i) {
		//if i is last element return as -1
		System.out.println("i:"+i);
		if(i==el.length) {
			return -1;
		}
		//if the element is before the last element
		else if(i==el.length-1) {
			return el[i];
		}
		else {
			int max=Integer.MIN_VALUE;
			for(;i<el.length;i++) {
				if(el[i] > max) {
					max = el[i];
				}
			}
			return max;
		}
	}

}
