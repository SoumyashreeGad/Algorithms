
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

import static java.lang.Math.max;
	
public class Rakshit {

	/**
	 * https://www.careercup.com/question?id=5656053464170496
	 * 
	 * Find the length of maximum number of consecutive numbers jumbled up in an array. 
	 * e.g.: 1, 94, 93, 1000, 2, 92, 1001 should return 3 for 92, 93, 94
	 */

	/**
	 * @author rakshith
	 *
	 */
		public static void main(String[] args) {
			int[] array = { 1, 3,4,56,78,41,91, 93, 100, 2, 92, 101};
			System.out.println("Max continuous length = "+maxContinuousLength2(array));
			String s = "11aa22bb33dd44S"; //110
			System.out.println("The string sum is "+stringSum(s));
			String s1 = "abc";
			String s2 = "de";
			printInterleave(s1,s2);
			int[] array1 = {2, 3, 13, 6, 4, 8, 1, 11, 0};
			System.out.println("Maximum profit made = "+maxProfit(array1));
			int[] arr = {1, 3, 5, 23, 2};int sum = 30;
			
			if(checkSumInSubsequence(arr,sum)){
				System.out.println("The given sum is present.");
			}else{
				System.out.println("The given sum is not present.");
			}
			int[] ar = {5, 3, 9, 1,2,6,10};
			int k = 3;
			System.out.println(k+"th largest number is "+kthLargest(ar,k));
			int[][] schedules = {{5,9},{5,7},{2,5},{3,9},{3,5},{9,15}};
			System.out.println("Minimum number of meeting rooms required is :" + minMeetingRooms(schedules));
			int size = 5;
			boolean[][] maze = null;
			
			ArrayList<String> path = getPath(maze);
			if (path != null) {
				System.out.println(path.toString());
			} else {
				System.out.println("No path found.");
			}
		}
		
		

		public static ArrayList<String> getPath(boolean[][] maze) {
			if (maze == null || maze.length == 0) return null;
			ArrayList<String> path = new ArrayList<String>();
			if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
				return path;
			}
			return null;
		}	
		
		public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<String> path) {
			// If out of bounds or not available, return.
			if (col < 0 || row < 0 || !maze[row][col]) {
				return false;
			}
			
			boolean isAtOrigin = (row == 0) && (col == 0);
			
			// If there's a path from the start to my current location, add my location.
			if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) { 
				String p=row+","+col;
				path.add(p);
				return true;
			}
			
			return false;
		}
		
		
		
		
		public static int minMeetingRooms(int[][] schedules){
			ArrayList<Integer> array = new ArrayList<Integer>(schedules.length*2);
			for(int i=0;i<schedules.length; i++){
				array.add(schedules[i][0]);
				array.add(schedules[i][1]*(-1));
			}
			
			Collections.sort(array, new Comparator<Integer>(){
				public int compare(Integer a, Integer b){
					if(Math.abs(a) != Math.abs(b))
						return Math.abs(a) - Math.abs(b);
					else 
						return a - b;
				}
			});
			
			System.out.println(array.toString());
			
			int minRooms = 0;
			int curRooms = 0;
			for(int i=0; i<array.size(); i++){
				if(array.get(i) > 0){
					curRooms++;
					minRooms = Math.max(minRooms, curRooms);
				}else{
					curRooms--;
				}
			}
			return minRooms;
		}
		
		
		public static int kthLargest(int[] array, int k){
			PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k+1);
			if(array.length < k+1){
				System.out.println("Array size is smaller than k.");
				return -1;
			}
			for(int i=0;i<k+1;i++){
				queue.add(array[i]);
				}
			for(int i=k+1; i<array.length; i++){
				if(array[i] > queue.peek()){
					queue.remove();
					queue.add(array[i]);
					}
			}
			return queue.peek();
		}

		
		
		//Works for array of positive numbers.
		public static boolean checkSumInSubsequence(int[] array, int sum){
			int startIndex = 0, endIndex = 0;
			int curSum = 0;
			for(int i=0; i<array.length; i++){
				curSum += array[i];
				endIndex++;
				if(curSum==sum){
					System.out.println("start = "+startIndex+", end = "+endIndex);
					return true;
				}else if(curSum < sum){
					continue;
				}else if(curSum > sum){
					while(curSum > sum){
						if(startIndex<endIndex){
							curSum -= array[startIndex];
							startIndex++;
						}
						else{
							break;
						}
					}
					if(curSum==sum){
						System.out.println("start = "+startIndex+", end = "+endIndex);
						return true;
					}
				}
			}
			return false;
		}
		
		
		public static int maxProfit(int[] array){
			int maxProfit = 0;
			int minSoFar = array[0];
			
			for(int i=0; i<array.length; i++){
				if(array[i] - minSoFar > maxProfit){
					maxProfit = array[i] - minSoFar;
				}else{
					if(array[i] < minSoFar){
						minSoFar = array[i];
					}
				}
			}
			return maxProfit;
		}
		
		//Using sorting.
		public static int maxContinuousLength(int[] array){
			int maxLength = 1, curLength = 1;
			Arrays.sort(array);
			int prev = array[0];
			for(int i=1; i<array.length; i++){
				if(prev == array[i]-1){
					curLength++;
				}else{
					maxLength = max(maxLength,curLength);
					curLength = 1;
				}
				prev = array[i];
			}
			return maxLength;
		}
		
		//using HashSet
		public static int maxContinuousLength2(int[] array){
			int maxLength = 0;
			HashSet<Integer> set = new HashSet<Integer>();
			for(int i=0; i<array.length; i++){
				set.add(array[i]);
			}
			System.out.println(set);
			for(Integer i: set){
				if(!set.contains(i-1)){
					int curLength = 0;
					while(set.contains(i)){
						i++;curLength++;
					}
					maxLength = max(maxLength, curLength);
				}
			}
			return maxLength;
		}
		
		public static int stringSum(String s){
			int sum = 0, curNumber = 0;
			for(int i=0; i<s.length();i++){
				if(Character.isDigit(s.charAt(i))){
					curNumber = curNumber*10 + (s.charAt(i)-'0');
				}else{
					sum += curNumber;
					curNumber = 0;
				}
			}
			return sum+curNumber;
		}
		
		
		public static void printInterleave(String s1,String s2){
			String soFar = "";
			printInterleaveUtil(s1,s2,0,0, soFar);
		}
		
		public static void printInterleaveUtil(String s1, String s2, int l1, int l2, String soFar){
			if(l1 == s1.length() && l2 == s2.length()){
				//System.out.println(soFar);
				return;
			}
			if(l1 < s1.length()){
				printInterleaveUtil(s1,s2,l1+1,l2,soFar+s1.charAt(l1));
				System.out.println(soFar);
			}
			if(l2 < s2.length()){
				printInterleaveUtil(s1,s2,l1,l2+1,soFar+s2.charAt(l2));
				System.out.println(soFar);
			}
		}
	}
