package java2022;

import java.util.Iterator;

public class BinarySearch implements Searcher {
	
	@Override
	public int search(int[] sortedValues, int value) {
		
		int max = sortedValues.length;
		
		int min = 0;
		
		int mid;
		
		while(min <= max) {
			
			mid = min + (max-min) / 2;
			
			if(value > sortedValues[mid]) {
				min = mid + 1;				
			}else if (value < sortedValues[mid]) {
				max = mid - 1;
			}else {
				return mid;
			}
		}
		
		return -1;
	}
}
