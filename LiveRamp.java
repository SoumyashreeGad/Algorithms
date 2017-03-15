
import java.awt.List;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;

public class LiveRamp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str=solution(1,5,3,4);
	}
	public static String solution(int A, int B, int C, int D) {
        // write your code in Java SE 8
		int[] arr={A,B,C,D};
		String hrs="";
		String sec="";
		Arrays.sort(arr);
		List list =new List();
		BitSet bits=new BitSet(4);
		if(arr[0]<=2){
			hrs=hrs+arr[0];
			bits.set(0);
		}
		else
			return "NOT POSSIBLE";
		if(arr[1]<=2){
			hrs=arr[1]+hrs;
			bits.set(1);
		}
		else{
			hrs=arr[3]+hrs;
			bits.set(3);
		}
		if(arr[2]<=5){
			sec=sec+arr[2];
		}
		if(!bits.get(1)){
			sec=sec+arr[1];
		}
		if(!bits.get(3)){
			sec=arr[3]+sec;
		}
			
        return hrs+":"+sec;
    }

}
