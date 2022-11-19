package com.scaler.arrays.class12;

/*
 XOR Sum
 
 Given two integers A and B. Find the minimum value (A ⊕ X) + (B ⊕ X) that can be achieved for any X.

where P ⊕ Q is the bitwise XOR operation of the two numbers P and Q.
Return the minimum value (A ⊕ X) + (B ⊕ X) that can be achieved for any X.


Example Input
Input 1:-
A = 6
B = 12
Input 2:-
A = 4
B = 9

Example Output
Output 1:-
10
output 2:-
13


Example Explanation
Expanation 1:-
X ^ A + X ^ B = 10 when X = 8
Explanation 2:-
X ^ A + X ^ B = 13 when X = 1

 */
public class XorMinSum {

    public static int solve(int A, int B) {
        int minSum = Integer.MAX_VALUE;
        for (int i = 1; i < 10; i++) {
            //if (A != i && B != i) {
            minSum = Math.min(minSum, (A ^ i) + (B ^ i));
            //}
        }
        return minSum;
    }

    public static void main(String[] args) {
        System.out.println(solve(6, 12));
        System.out.println(solve(4, 9));
    }

}
