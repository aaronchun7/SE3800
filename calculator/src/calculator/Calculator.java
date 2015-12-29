package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This is a simple terminal calculator application.
 * @maxcharacterline 70
 * @author Jimmy Kuczynski - kuczynskij
 * @author Aaron Chun - chunaa
 */
public class Calculator {
	
	//Scanner object to get user input.
	private static Scanner in;
	
	/**
	 * Runs the program.
	 * @param args
	 */
	public static void main(String [] args){
		help();
	}
	
	/**
	 * Displays a welcome text and the commands available. 
	 */
	private static void help(){
		System.out.println("Welcome to Team Wolfpack's fantastic "
				+ "terminal calculator!");
		System.out.println("Supported commands: add, sub, mult, div,"
				+ " hist, clear, reuse, wombo");
		in = new Scanner(System.in);
		getUserInput();
	}
	
	/**
	 * Gets user input.
	 * @author kuczynskij
	 */
	private static void getUserInput(){
		System.out.print("Enter command: ");
		String cmd = in.next();
		List<Integer> list;
		switch(cmd){
			case "add":
				list = getIntegers();
				if (list != null)
					add(list);
				getUserInput();
				break;
			case "sub":
				//TODO
				break;
			case "mult":
				list = getIntegers();
				if (list != null)
					mult(list);
				getUserInput();
				break;
			case "div":
				//TODO
				break;
			case "hist":
				//TODO
				break;
			case "clear":
				//TODO
			break;
			case "reuse":
				//TODO
				break;
			case "wombo":
				//TODO
			break;
			case "help":
				help();
				break;
			case "quit":
				System.out.println("Thanks for using me I guess...");
				System.exit(0);
				break;
			default:
				getUserInput();
				break;
		}	
	}
	
	/**
	 * Validates user input to ensure that a list of integers has
	 * been passed in. Then returns them as a List of Integers.
	 * @author kuczynskij & chuna
	 * @return l -> List of user inputed integers
	 */
	private static List<Integer> getIntegers(){
		List<Integer> l = new ArrayList<Integer>();		
		String intStr = in.nextLine().trim();
		System.out.println("This is the number input provided: " 
			+ intStr);
        String intStrArr [] = intStr.split(" ");
        try{
        	for (int i = 0; i < intStrArr.length; i++) {
	            System.out.println("Item #" + i + " is " +
	                    intStrArr[i]);
	            int temp = Integer.parseInt(intStrArr[i]);
	            l.add(temp);
            }
        }catch(NumberFormatException nfe){
            System.out.println("There was an error in the numbers " 
            	+ "provided. Command did not finish executing.");
            getUserInput();
        }
		return l;
	}
	
	/**
	 * User Story #1
	 * Adds the a list of positive Integers.
	 * @author kuczynskij
	 * @param l - list of integers
	 * @return positive sum
	 */
	public static void add(List<Integer> l){
		int sum = 0;
		for(Integer i : l){
			sum += i;
		}
		System.out.println("The sum is: " + sum);
	}
	
	/**
	 * User Story #2
	 * @author chuna
	 * @return
	 */
	public int sub(List<Integer> l){
		//TODO
		return 0;
	}
	
	/**
	 * User Story #3
	 * Multiples the a list of positive Integers.
	 * @author kuczynskij
	 * @param l - list of integers
	 * @return
	 */
	public static void mult(List<Integer> l){
		int product = 1;
		for(Integer i : l){
			product *= i;
		}
		System.out.println("The product is: " + product);
	}
	
	/**
	 * User Story #4
	 * @author chuna
	 * @return
	 */
	public int div(List<Integer> l){
		//TODO
		return 0;
	}
	
	/**
	 * User Story #5
	 * Prints out the previous computation history the user as input.
	 * @author kuczynskij
	 * @param num	Result of the 
	 * @return
	 */
	public int hist(int num){
		//TODO
		return 0;
	}
	
	/**
	 * User Story #6
	 * @author chuna
	 * @return
	 */
	public boolean clear(){
		//TODO
		return false;
	}
	
	/**
	 * User Story #7
	 * Allows the user to use previous results in current calculations.
	 * Ex: 8 + 3 = 8; -> 2 + result = 10
	 * @author kuczynskij
	 */
	public void reuse(){
		//TODO
	}
	
	/**
	 * User Story #8
	 * @author chuna
	 */
	public void wombo(){
		//TODO
	}
}
