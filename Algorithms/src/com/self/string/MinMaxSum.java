package self;

public class MinMaxSum {

	public static void main(String[] args) {
		int[] input = {1, 3, 5, 7, 9};
		
		findMinMaxSum(input);
	}
	
	private static void findMinMaxSum(int[] input) {
		int excludeIdx = 0;
		int minSum = 0;
		int maxSum = 0;
		
		do {
			int tmpSum = 0;
			
			for(int idx = 0; idx < input.length; idx++) {
				if(idx != excludeIdx) {
					tmpSum += input[idx];
				}
			}
			
			if(minSum == 0 || minSum > tmpSum) {
				minSum = tmpSum;
			}

			if(maxSum == 0 || maxSum < tmpSum) {
				maxSum = tmpSum;
			}
		}while(++excludeIdx < input.length);
		
		System.out.println(minSum + " " + maxSum);
	}
}
