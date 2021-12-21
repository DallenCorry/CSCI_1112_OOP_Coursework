package recursion;

public class GCD {
	
	public static int gcd(int m, int n) {
		//base case
		if (m%n == 0) {
			return n;
		}else
			//recursive case
			return gcd(n, m%n);
	}
	
	public static void main(String[] args) {
		System.out.println("GCD of 12 and 4 is: "+gcd(12,4));
		System.out.println("GCD of 126 and 18 is: "+gcd(126,18));
		System.out.println("GCD of 128 and 7 is: "+gcd(128,7));
		
		int x = 126;
		int y = 18;
		System.out.print("GCD of "+x+" and "+y+" is: ");
		//recursion is really not necesary in this case, 
		//as it can be written in the following line of code:
		System.out.println(x%y == 0 ? y : x%y);		
	}

}
