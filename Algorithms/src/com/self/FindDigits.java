package com.self;

/**
 * @author ranjithr
 *
 * An integer "d" is a divisor of an integer "n" if the remainder of "n / d = 0".
 * Given an integer, for each digit that makes up the integer determine whether it is a divisor. Count the number of divisors occurring within the integer.
 * Example:  12 => broken into two digits, 1 and 2. When 12 is divided by either of those two digits, the remainder is 0 so they are both divisors.
 */
public class FindDigits {
	public static void main(String[] args) {
		System.out.println(findDigits(123456789));
	}
	
	static int findDigits(long n) {
        int count = 0;

        while(n > 0){
            long divisor = n % 10;

            if((divisor > 0) && ((n % divisor) == 0)){
                count++;
            }

            n = n / 10;
        }

        return count;
    }
}
