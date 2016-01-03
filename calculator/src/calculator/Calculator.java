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
	
	private static ArrayList<Calculation> history 
		= new ArrayList<>();
	
	private static Calculation calc;
	
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
				+ " hist, clear, reuse, wumbo");
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
		switch(cmd){
			case "add":
				add();
				break;
			case "sub":
				sub();
				break;
			case "mult":
				mult();
				break;
			case "div":
				div();
				break;
			case "hist":
				hist();
				break;
			case "clear":
				clear();
				break;
			case "reuse":
				/* 
				 * TODO don't need because will be used in the array
				 * 		of integers passed in.
				 */
				break;
			case "wumbo":
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
				 //Clear the buffer of any extra things input 
				 //after the incorrect command.
				in.nextLine();
				System.out.println("Woops, looks like you inputed an"
						+ " invalid command.");
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
	private static List<Integer> getIntegers(Calculation c){
		List<Integer> l = new ArrayList<Integer>();		
		String intStr = in.nextLine().trim();
		// TODO use for debugging, delete later
//		System.out.println("This is the number input provided: " 
//			+ intStr);
        String intStrArr [] = intStr.split(" ");
        try{
        	for (int i = 0; i < intStrArr.length; i++) {
//	            System.out.println("Item #" + i + " is " +
//	                    intStrArr[i]); TODO for debugging delete
        		int val;
	            if(intStrArr[i].contains("!")){
	            	//TODO run the reuse method to get the value needed
	            	int index = Integer.parseInt(
	            			intStrArr[i].substring(1));
	            	val = reuse(index, c);
	            }else{
	            	val = Integer.parseInt(intStrArr[i]);
	            }
        		
	            l.add(val);
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
	 * @return non-negative sum
	 */
	public static void add(){
		calc = new Calculation("add");
		List<Integer> list = getIntegers(calc);
		if (list != null){
			calc.setInput(list);
			int sum = 0;
			for(Integer i : list){
				sum += i;
			}
			System.out.println("The sum is: " + sum);
			calc.setAns(sum);
		}
		history.add(calc);
		getUserInput();
	}
	
	/**
	 * User Story #2
	 * Subtracts the list of integers
	 * @author chuna
	 */
	public static void sub(){
		calc = new Calculation("sub");
		List<Integer> list = getIntegers(calc);
		if(list != null){
			calc.setInput(list);
			int dif = list.get(0);
			for(int i = 1; i < list.size(); i++){
				dif -= list.get(i);
			}
			System.out.println("The difference is: " + dif);
			calc.setAns(dif);
		}
		history.add(calc);
		getUserInput();
	}
	
	/**
	 * User Story #3
	 * Multiples the a list of positive Integers.
	 * @author kuczynskij
	 * @param l - list of integers
	 * @return
	 */
	public static void mult(){
		calc = new Calculation("mult");
		List<Integer> list = getIntegers(calc);
		if (list != null){
			calc.setInput(list);
			int product = 1;
			for(Integer i : list){
				product *= i;
			}
			System.out.println("The product is: " + product);
			calc.setAns(product);
		}
		history.add(calc);
		getUserInput();
	}
	
	/**
	 * User Story #4
	 * Divides the list of integers and uses integer division.
	 * Has a check for zero division
	 * @author chuna
	 */
	public static void div(){
		calc = new Calculation("div");
		List<Integer> list = getIntegers(calc);
		boolean divZero = false;
		if(list != null){
			calc.setInput(list);
			int quot = list.get(0);
			for(int i = 1; i < list.size(); i++){
				if(list.get(i) != 0){
					quot /= list.get(i);
				}else{
					divZero = true;
					break;
				}
			}
			if(divZero){
				System.out.println("Error: Cannot divide by zero.");
				getUserInput();
			}
			System.out.println("The quotient is: " + quot);
			calc.setAns(quot);
		}
		history.add(calc);
		getUserInput();
	}
	
	/**
	 * User Story #5
	 * Prints out the previous computation history the user as input.
	 * @author kuczynskij
	 */
	public static void hist(){
		int h = history.size();
		if(h > 0){
			System.out.println("Printing out calculation history.");
			for(int i = 0; i < h ;++i){
				System.out.println(
						(i + 1) + " | " + history.get(h-(1 + i)));
			}
		}else{
			System.out.println("There is no history to display.");
		}
		getUserInput();
	}
	
	/**
	 * User Story #6
	 * Clears the history list by assigning the history attribute to
	 * a new ArrayList.
	 * @author chuna
	 */
	public static void clear(){
		try{
			history = new ArrayList<Calculation>();
			System.out.println("The Calculation history has been"
					+ " cleared.");
		}catch(Exception e){
			System.out.println("Error: History may not have been "
					+ "cleared.");
		}
		getUserInput();
	}
	
	/**
	 * User Story #7
	 * Allows the user to use previous results in current 
	 * calculations.
	 * Ex: 5 + 3 = 8; -> 2 + result = 10
	 * @author kuczynskij
	 * @param num - number of history result
	 */
	public static int reuse(int num, Calculation c){
		if (history.size() > 0 && num > 0 && history.size() > num){
			return history.get(history.size() - num).getAns();
		}else{
			//apply identity property
			//apply 0 to sub or add
			//apply 1 to mult or div
			String cmd = c.getCmd();
			switch(cmd){
				case "add":
					return 0;
				case "sub":
					return 0;
				case "mult":
					return 1;
				case "div":
					return 1;
				default:
					return 0;
			}
		}
	}
	
	/**
	 * User Story #8
	 * @author chuna
	 */
	public void wumbo(){
		//TODO
	}
}
