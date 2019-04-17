package com.self.hackerrank;

/**
 * @author ranjithr
 *
 * Sherlock must determine the number of square integers within that range, inclusive of the endpoints.
 * Note: A square integer is an integer which is the square of an integer, e.g. 1, 4, 9, 16, 25.
 * 
 * Example: a: 3, b: 9 => Output: 2.
 * In range [3 9], 4 and 9 are the two square integers. 
 */
public class SherlockAndSquares {

	public static void main(String[] args) {
		System.out.println("Sherlock and Squares: " + squares(3, 9));
		System.out.println("Sherlock and Squares: " + squares(17, 21));
		System.out.println("Sherlock and Squares: " + squares(24, 49));
	}
	
	static int squares(int a, int b) {
        int count = 0;
        int pow = 1;
        long curValue = pow;

        while(curValue <= b){
            if(curValue >= a && curValue <= b){
                count++;
            }

            pow += 2;
            curValue += pow;
        }

        return count;
    }
}
