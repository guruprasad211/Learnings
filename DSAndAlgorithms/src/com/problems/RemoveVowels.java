package com.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RemoveVowels {
	
	static Map<String,Integer> vowels = new HashMap<String,Integer>();
	public void initVowels() {
		vowels.put("a",1);
		vowels.put("e",1);
		vowels.put("i",1);
		vowels.put("o",1);
		vowels.put("u",1);
	}
    String removeVowels(String S) {
    	initVowels();
    	//takes more time to pass test cases in geeksforgeeks
        char[] charArr=S.toCharArray();
        String output="";
        for(int i=0;i<charArr.length;i++){
            if(!vowels.containsKey(charArr[i])){
                output+=charArr[i];
            }
        }
        return output;
    }
    
    static String modify(String s){
        String r="";
        for(int i=0;i<s.length();i++){
        	String s1=String.valueOf(s.charAt(i));
            if(s.charAt(i) >= 'a' || s.charAt(i) <='z'){
                r+=s1.toUpperCase();
            } else if(s.charAt(i) >= 'A' || s.charAt(i) <='Z') {
                r+=s1.toLowerCase();
            }
        }
        return r;
    }
    
    String removeVowels2(String S) {
    	initVowels();
    	
    	for(Entry<String,Integer> e : vowels.entrySet()) {
    		S=S.replace(e.getKey(), "");
    	}
    	
    	return S;
    }
    
	public static void main(String[] args) {
		System.out.println(new RemoveVowels().removeVowels2("guru Prasad"));
		System.out.println(""+RemoveVowels.modify("abCD"));
	}

}
