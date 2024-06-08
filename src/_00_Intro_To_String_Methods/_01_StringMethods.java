package _00_Intro_To_String_Methods;

import java.util.Arrays;
import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return s1;
		}
		return s2;
	}

	// If String s contains the word "underscores", change all of the spaces
	// to underscores
	public static String formatSpaces(String s) {
		if (s.contains("underscores"))
	
		{
			String n = s.replace(" ", "_");
			return n;
		}
		return s;
	}

	// Return the name of the person whose LAST name would appear first if they
	// were in alphabetical order.
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		char last1 = s1.trim().split(" ")[1].charAt(0);
		char last2 = s2.trim().split(" ")[1].charAt(0);
		char last3 = s3.trim().split(" ")[1].charAt(0);
		char[] lastInitials = {last1, last2, last3};
		Arrays.sort(lastInitials);
		if(lastInitials[0]==last1) {
			return s1.trim();
		}
		if(lastInitials[0]==last2) {
			return s2.trim();
		}
		if(lastInitials[0]==last3) {
			return s3.trim();
		}
		return null;
	}

	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		char[] cs = s.toCharArray();
		int sum = 0;
		for(char c: cs) {
			if(Character.isDigit(c)) {
				sum+=Integer.parseInt(String.valueOf(c));
			}
		}
		return sum;
	}

	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int count = 0;
		String n = s.replace(substring, "");
		int diff = s.length()-n.length();
		return diff/substring.length();
	}

	// Call Utilities.encrypt at the bottom of this file to encrypt String s
	public static String encrypt(String s, char key) {
		byte[] bytes = s.getBytes();
		return Utilities.encrypt(bytes, (byte)key);
	}

	// Call Utilities.decrypt at the bottom of this file to decrypt the
	// cyphertext (encrypted text)
	public static String decrypt(String s, char key) {
		return Utilities.decrypt(s, (byte)key);
	}

	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		String[] words=s.split(" ");
		int sum = 0;
		for(String st: words) {
			if(st.length()>=substring.length()) {
			if(st.substring(st.length()-(substring.length())).equals (substring)) {
				sum++;
			}
			}
		}
		return sum;
	}

	// Given String s, return the number of characters between the first
	// occurrence of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		return s.lastIndexOf(substring)-s.indexOf(substring)-substring.length();
	}

	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		//"tacocat"
		//length = 7
		s=s.trim();
		s=s.replace(" ", "");
		String good = "";
		for(int i = 0; i<s.length();i++) {
			if(Character.isLetter(s.charAt(i))) {
				good+=Character.toLowerCase(s.charAt(i));
			}
		}
		char[] chars = good.toCharArray();
		System.out.println(good);
		for(int i = 0; i<chars.length;i++) {
			if(chars[i]!=chars[chars.length-(1+i)]) {
				return false;
			}
		}
		return true;
	}
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a
	// single byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
