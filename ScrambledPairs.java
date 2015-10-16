package test;

import java.util.ArrayList;
import java.util.HashSet;

public class ScrambledPairs {

	public static int total = 0;
	static int newNum = 0;

	public void getPairs(int A, int B) {
		int totalPair = 0;
		ArrayList<Integer> newPair = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> arrList = new ArrayList<Integer>();

		for (int i = A; i <= B; i++) {
			arrList.clear();
			char[] charArr = changeToCharArr(i);
			newPair = arrange(charArr, 0, charArr.length - 1, arrList, set, i, B);
			//System.out.println(newPair);
			
			totalPair += newPair.size();
			
			for (Integer list : newPair) {
				// System.out.print(list + "+ ");
				// System.out.println(i);

				if (list > i && list < B) {
					System.out.println(i + ":" + list);
					//totalPair++;
				}
			}
			
		}
		// System.out.println(newPair);
		System.out.print(totalPair);
	}

	public static ArrayList<Integer> arrange(char[] str, int st, int len,
			ArrayList<Integer> list, HashSet<Integer> set, int A, int B) {

		String newStr = "";
		if (st == len) {
			for (int i = 0; i <= len; i++) {
				// System.out.print(str[i] + "  ");
				newStr += str[i];
				if (newStr.length() == len + 1) {
					newNum = Integer.parseInt(newStr);
					
					if (newNum > A && newNum < B){
						if (!set.contains(newNum)) {
							set.add(newNum);
							list.add(newNum);
						}
					}
					
				}
			}
		} else {
			for (int i = st; i <= len; i++) {
				swap(str, st, i);
				arrange(str, st + 1, len, list, set, A, B);
				swap(str, st, i);
			}
		}
		// System.out.println(list);
		return list;
	}

	public static void swap(char[] str, int i, int j) {
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}

	public static char[] changeToCharArr(int A) {
		String s = Integer.toString(A);
		char[] carr = s.toCharArray();
		return carr;
	}

	public static void main(String[] args) {
		ScrambledPairs sp = new ScrambledPairs();
		sp.getPairs(10000000, 20000000);
	}
}
