package self;

public class FindLeaderInIntegerArray {

	public static void main(String[] args) {
		int[] input = {8, 23, 19, 21, 15, 6, 11};
		
		System.out.print("Leaders are: " + input[input.length - 1]);
		
		for(int idx = input.length - 1; idx > 0; idx--) {
			if(input[idx - 1] > input[idx]) {
				System.out.print(" " + input[idx - 1]);
			}
		}
	}

}
