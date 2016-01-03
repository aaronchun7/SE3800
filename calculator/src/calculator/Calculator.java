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
	
	public static ArrayList<Calculation> history 
		= new ArrayList<>();
	
	private static Calculation calc;
	
	private static boolean wumbo = false;
	
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
				+ " hist, clear, reuse, wumbo, help");
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
				if(!wumbo)
					add(null);
				else
					sub();
				break;
			case "sub":
				if(!wumbo)
					sub();
				else
					add(null);
				break;
			case "mult":
				if(!wumbo)
					mult();
				else
					div();
				break;
			case "div":
				if(!wumbo)
					div();
				else
					mult();
				break;
			case "hist":
				hist();
				break;
			case "clear":
				clear();
				break;
			case "wumbo":
				wumbo();
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
		getUserInput();
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
        String intStrArr [] = intStr.split(" ");
        try{
        	for (int i = 0; i < intStrArr.length; i++) {
        		int val;
	            if(intStrArr[i].contains("!")){
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
	 * @param list - list of integers
	 * @return non-negative sum
	 */
	public static int add(List<Integer> list){
		calc = new Calculation("add");
		int sum = 0;
		if (list == null)
			list = getIntegers(calc);
		if (list != null){
			calc.setInput(list);
			for(Integer i : list){
				sum += i;
			}
			System.out.println("The sum is: " + sum);
			calc.setAns(sum);
		}
		history.add(calc);
		return sum;
	}
	
	/**
	 * User Story #2
	 * Subtracts the list of integers
	 * @author chuna
	 */
	public static int sub(){
		calc = new Calculation("sub");
		int dif = 0;
		List<Integer> list = getIntegers(calc);
		if(list != null){
			calc.setInput(list);
			dif = list.get(0);
			for(int i = 1; i < list.size(); i++){
				dif -= list.get(i);
			}
			System.out.println("The difference is: " + dif);
			calc.setAns(dif);
		}
		history.add(calc);
		return dif;
	}
	
	/**
	 * User Story #3
	 * Multiples the a list of positive Integers.
	 * @author kuczynskij
	 * @param l - list of integers
	 * @return
	 */
	public static int mult(){
		calc = new Calculation("mult");
		int product = 1;
		List<Integer> list = getIntegers(calc);
		if (list != null){
			calc.setInput(list);
			for(Integer i : list){
				product *= i;
			}
			System.out.println("The product is: " + product);
			calc.setAns(product);
		}
		history.add(calc);
		return product;
	}
	
	/**
	 * User Story #4
	 * Divides the list of integers and uses integer division.
	 * Has a check for zero division
	 * @author chuna
	 * @throws Exception 
	 */
	public static int div(){
		calc = new Calculation("div");
		int quot = 0;
		List<Integer> list = getIntegers(calc);
		boolean divZero = false;
		if(list != null){
			calc.setInput(list);
			quot = list.get(0);
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
		return quot;
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
	 * If true, swaps add with sub and swaps mult with div.
	 * @author chuna
	 */
	public static void wumbo(){
		if (!wumbo){
			wumbo = true;
			System.out.println("I wumbo, you wumbo, he, she, me, "
					+ "wumbo. Wumbo; wumboing; we'll have thee "
					+ "wumbo; wumborama; wumbology, the study of "
					+ "wumbo! It's first grade stuff, User!");
		}else{
			wumbo = false;
			System.out.println("Mini-mode.");
		}
	}
}
