package parsingAndStringManipulation;

public class RegularExpressions {
	public static void main(String [] args) {
		String s = "one/two/three(fo ur)<five>six;seven():eight_nine";
		System.out.println(s);
		s.replace("/","");
		System.out.println(s);
	}
}
