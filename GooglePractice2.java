package basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class GooglePractice2 {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		String str1 = key.nextLine();
		String str2 = key.nextLine();
		System.out.println(perm(str1, str2));

	}

	public static boolean perm(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		StringBuilder sb = new StringBuilder();
		sb.append(str1);
		for (int i = 0; i < str1.length(); i++) {
			// System.out.println("entered");
			// System.out.println("sb= "+sb+"str= "+str2);
			if (sb.toString().equals(str2)) {
				// System.out.println("sb= "+sb+"str= "+str2);
				return true;
			}
			sb.append(sb.charAt(0));
			System.out.println(sb);
			sb.delete(0, 1);
			System.out.println("after delete " + sb);
		}
		return false;

	}
}
