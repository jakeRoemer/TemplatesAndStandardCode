package parsingAndStringManipulation;

public class PatternMatching {
	public static void main(String [] args) {
		String [] s = new String[10];
		for (int i = 0; i < s.length; i++) {
			s[i] = "FT" + i + "Schedule#-X:vm:threadSchedule=" + i;
		}
		System.out.println("start");
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
			System.out.println(s[i].matches(".*:threadSchedule=[0-9]"));
		}
		System.out.println("end");
	}
}
