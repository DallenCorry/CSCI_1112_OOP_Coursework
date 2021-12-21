package recursion;

public class Reverse {
	
	public static void reverseDisplay(String s) {
		//no base case, as return is void
		if (s.length()>0) {
			System.out.print(s.charAt(s.length()-1));
			reverseDisplay(s.substring(0, s.length()-1));
		}
	}
	
	public static void main(String[] args) {
		reverseDisplay("Hello world!");
		System.out.println();
		reverseDisplay("Racecar");
		System.out.println();
		reverseDisplay("TacoCat");
		System.out.println();
		reverseDisplay("This is Not a Palindrome");
	}
}
