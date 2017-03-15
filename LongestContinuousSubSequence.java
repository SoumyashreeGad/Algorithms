import static java.lang.Math.min;
import static java.lang.Math.max;
public class LongestContinuousSubSequence {
	public static void main(String[] args) {
		//int[] array = {14, 12, 11, 20};//2
		int[] array = {1, 56, 58, 57, 55,54,53, 90, 92, 94, 93, 91};//5
		
		printLongestContiguousSubarray(array);
	}
	
	public static void printLongestContiguousSubarray(int[] array){
		int maxLength = 1;
		int max,min;
		for(int i=0; i<array.length; i++){
			max = array[i];
			min = array[i];
			for(int j=i+1; j< array.length; j++){
				max = max(max,array[j]);
				min = min(min,array[j]);
				//System.out.println(max+" "+min+" "+i+" "+j);
				if(j-i == max-min){
					maxLength = max(maxLength,j-i+1);
				}
			}
		}
		System.out.println("The max length is "+maxLength);
	}
}
