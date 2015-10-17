package test;
import java.util.HashSet;

public class theOne {

	public static long[] total = new long[1];
	static long newNum = 0;

	public void getPairs(int A, int B) {
		long totalPair = 0;

		HashSet<Long> set = new HashSet<Long>();

		for (int i = A; i <= B; i++) {
			total[0] = 0;
			set.clear();
			char[] charArr = changeToCharArr(i);
			arrange(charArr, 0, charArr.length - 1, total, set, i, B);

			totalPair += total[0];

		}

		System.out.print(totalPair);
	}

	public static void arrange(char[] str, int st, int len, long[] total,
			HashSet<Long> set, int A, int B) {

		String newStr = "";
		if (st == len) {

			for (int i = 0; i <= len; i++) {

				newStr += str[i];
				if (newStr.length() == len + 1) {
					newNum = Integer.parseInt(newStr);

					if (newNum > A && newNum < B) {
						if (!set.contains(newNum)) {
							total[0]++;
							set.add(newNum);
							System.out.print(A + "->");
							System.out.println(newNum);
							//System.out.println(".");
						}
					}

				}
			}
			return;
		} else {
			for (int i = st; i <= len; i++) {
				swap(str, st, i);
				arrange(str, st + 1, len, total, set, A, B);
				swap(str, st, i);
			}
		}

		return;
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
		theOne sp = new theOne();
		sp.getPairs(100, 999);
	}
}
