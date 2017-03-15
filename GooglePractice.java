package basic;

import java.util.ArrayList;
import java.util.Scanner;

public class GooglePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int length = longestSequence(n);
		System.out.println(length);
	}

	private static int longestSequence(int n) {
		if (n == -1) {
			return Integer.BYTES * 8;
		}
		ArrayList<Integer> sequences = getAlternateSequences(n);
		return findLongestSequence(sequences);

	}

	private static ArrayList<Integer> getAlternateSequences(int n) {
		ArrayList<Integer> sequences = new ArrayList<Integer>();
		int searchFor = 0;
		int counter = 0;

		for (int i = 0; i < Integer.BYTES * 8; i++) {
			if ((n & 1) != searchFor) {
				sequences.add(counter);
				searchFor = n & 1;
				counter = 0;
			}
			counter++;
			System.out.println("n before shifting" + n);
			n >>>= 1;
			System.out.println("n after shifting" + n);
		}
		sequences.add(counter);
		return sequences;

	}

	private static int findLongestSequence(ArrayList<Integer> seq) {
		int maxSeq = 1;
		for (int i = 0; i < seq.size(); i += 2) {
			int zeroSeq = seq.get(i);
			int oneSeqRgt = i - 1 >= 0 ? seq.get(i - 1) : 0;
			int oneSeqLft = i + 1 < seq.size() ? seq.get(i + 1) : 0;

			int thisSeq = 0;
			if (zeroSeq == 1) {
				thisSeq = oneSeqLft + 1 + oneSeqRgt;
			}
			if (zeroSeq > 1)
				thisSeq = 1 + Math.max(oneSeqLft, oneSeqRgt);
			else if (zeroSeq == 0)
				thisSeq = Math.max(oneSeqLft, oneSeqRgt);
			maxSeq = Math.max(thisSeq, maxSeq);
		}
		return maxSeq;

	}

}
