package com.self.hackerrank;

/**
 * Delete a characters within a string so that both strings becomes equal.
 * 
 * Example:
 * Input: 	"heat", "hit"
 * Output:	3 -> By removing 'e', 'a' and 'i', so that both strings becomes equal.
 * 
 * @author ranjithr
 *
 */
public class DeletionDistanceBetweenStrings {
	public static void main(String[] args) {
		System.out.println(deletionDistance("heat", "hit"));
	}
	
	private static int deletionDistance(String str1, String str2) {
		if(str1.equals(str2)) {
			return 0;
		}
		
		if("".equals(str1)) {
			return str2.length();
		}
		
		if("".equals(str2)) {
			return str1.length();
		}
		
		int oIdx = 0;
		int iIdx = 0;
		int distance = 0;
		String tmpStr1 = "";
		String tmpStr2 = "";
		String deletedStr = "";
		int str2Pos = 0;
		
		for(oIdx = 0; oIdx < str1.length(); oIdx++) {
			String oSubStr = str1.substring(oIdx, oIdx + 1);
			
			for(iIdx = str2Pos; iIdx < str2.length(); iIdx++) {
				String iSubStr = str2.substring(iIdx, iIdx + 1);
				
				if(oSubStr.equals(iSubStr)) {
					str2Pos++;
					tmpStr1 = str1.substring(oIdx + 1);
					break;
				}
			}
			
			if(iIdx == str2.length()) {
				deletedStr += oSubStr;
				tmpStr1 = str1.substring(oIdx + 1);
				str2Pos = 0;
			}
		}
		
		return distance;
	}
}
