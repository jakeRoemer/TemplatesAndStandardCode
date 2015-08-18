package dynamicProgramming;

public class LongestCommonSubstring {
	
	static String s1 = "Hello";
	static String s2 = "Sally";
	static int [][] c = new int[s1.length()][s2.length()];
	
	public static void main(String [] args) {
		System.out.println("longest common substring between " + s1 + " and " + s2 + " is " + LCS() + " long.");
	}
	
	public static int LCS () {
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				//assuming a common substring length can not be negative
				c[i][j] = -1;				
			}
		}
		return check(s1.length()-1,s2.length()-1);
	}
	
	public static int check (int i, int j) {
		if (i == 0 || j == 0) {
			return 0;
		}
		if (c[i][j] != -1) {
			return c[i][j];
		} else {
			if (s1.charAt(i) == s2.charAt(j)) {
				c[i][j] = check(i-1,j-1) + 1;
			} else {
				int max = check(i-1,j);
				int max2 = check(i,j-1);
				if (max < max2) {
					c[i][j] = max2;
				} else {
					c[i][j] = max;
				}
			}
		}
		return c[i][j];
	}
}
