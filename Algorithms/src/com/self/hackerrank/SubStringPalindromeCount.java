package com.self.hackerrank;

public class SubStringPalindromeCount {
	
	public static void main(String[] args) {
		System.out.println("Sub String Palindrome Count is: " + countPalindromes("sasasas"));
	}
	
	public static int countPalindromes(String s) {
		int count = 0;
		
		for(int oIdx = 0; oIdx < s.length(); oIdx++) {
			for(int iIdx = oIdx + 1; iIdx <= s.length(); iIdx++) {
				String subStr = s.substring(oIdx, iIdx);
				
				if(subStr.length() == 1) {
					count++;
				}else if(isPalindrome(subStr)) {
					count++;
				}
			}
		}

		return count;
    }
	
	private static boolean isPalindrome(String str){
		char[] tmpStr = str.toCharArray();
        int start = 0;
        int end = tmpStr.length - 1;
        boolean result = true;
                
        while(start < end) {
        	if(tmpStr[start] != tmpStr[end]) {
        		result = false;
        		break;
        	}
        	
        	start++;
        	end--;
        }
        
        return result;
    }
}
