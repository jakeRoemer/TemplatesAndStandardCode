package parsingAndStringManipulation;

public class RegularExpressions {
	public static void main(String [] args) {
		String s = "one/two/three(fo ur;)<five>six;seven(45):eight_nine";
		System.out.println(s);
		s = s.replaceAll("\\([^0-9]*?\\)","()");
		System.out.println(s);
	}
}
