package com.scaler.strings;

import java.util.*;

public class VowelSubsequence {
	
	public static String vowelSeq(String A) {
		StringBuilder sb = new StringBuilder();
        Map<Character, Integer> vowels = new HashMap<>();
        vowels.put('a', 1);
        vowels.put('e', 1);
        vowels.put('i', 1);
        vowels.put('o', 1);
        vowels.put('u', 1);
        
        for(int i=0;i<A.length();i++){
            if(vowels.containsKey(A.charAt(i))){
            	sb.append(A.charAt(i));
            }
        }
        return sb.toString();
	}
	
	public static void main(String[] args) {
		
		System.out.println(vowelSeq("interviewbit"));

	}

}
