package stacks;

public class PalindromeChecker extends Stack {
	// data fields
	private Stack<Character> s;
	private String str;
	
	// Constructor
	PalindromeChecker(String s) {
		fillStack(s);
		this.str=s;
	}
	
	private void fillStack(String s) {
		//fills the stack using the provided string
		for(int i=0;i<s.length();i++) {
			this.push(s.charAt(i));
		}
	}
	
	private String reverseString() {
		String builder = "";
		for(int i=str.length()-1;i>=0;i--) {
			builder += str.charAt(i);
		}
		
		return builder;
	}
	
	public Boolean isPalindrome() {
		return str.equals(reverseString());
	}
	
	public static void main(String[] args) {
		// code to test your solution 
		// include examples and non-examples
		PalindromeChecker p = new PalindromeChecker("dad");
		System.out.println(p.reverseString());
		System.out.println(p.isPalindrome());
	}
}
