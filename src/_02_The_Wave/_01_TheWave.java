package _02_The_Wave;

import java.util.ArrayList;

public class _01_TheWave {
    /*
     * Background:
     * https://en.wikipedia.org/wiki/Wave_%28audience%29 
     * 
     * Task:
     * Your task is to create a function that turns a string into a Wave.
     * You will be passed a string and you must return that string in an
     * ArrayList where an uppercase letter is a person standing up.
     * Example:
     * wave("hello") => "Hello", "hEllo", "heLlo", "helLo", "hellO"
     * 
     * 1. The input string will always be lower case but maybe empty.
     * 2. If the character in the string is whitespace then pass over it as
     *    if it was an empty seat.
     */
    //i value for each letter
	//each time check if letter is space
	//if space, end
	//else add to array the word w capitalized letter
	//then return the array
    public static ArrayList<String> wave(String str) {
        StringBuilder chars = new StringBuilder(str);
        ArrayList<String> strings = new ArrayList<String>();;
        for(int i = 0; i<chars.toString().length();i++) {
        	if(chars.charAt(i)!=' ') {
        		chars.replace(i, i+1, Character.toString(Character.toUpperCase(chars.charAt(i))));
        		strings.add(chars.toString());
        		chars.replace(i, i+1, Character.toString(Character.toLowerCase(chars.charAt(i))));
        	}
        }
        return strings;
    }
}
