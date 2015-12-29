package calculator;

import java.util.List;

/**
 * This object will hold the information for each of the 
 * calculations made.
 * @author Aaron
 *
 */
public class Calculation {
	
	// The command entered (add, sub, mult, div,hist, wombo).
	private String command;
	
	// The List of integers that was inputed after the command.
	private List<Integer> input;
	
	// The answer to the command used.
	private int answer;
	
	/**
	 * Constructor
	 * @param command	The valid command that inputed besides the 
	 * clear method.
	 */
	public Calculation(String command){
		this.command = command;
	}
	
	/**
	 * Getter method for the command attribute.
	 * @return	The command attribute for the Calculation.
	 */
	public String getCmd(){
		return command;
	}
	
	/**
	 * Getter method for the input attribute.
	 * @return	The list of integers that was inputed with the 
	 * command for the Calculation.
	 */
	public List<Integer> getInput(){
		return input;
	}
	
	/**
	 * Setter for the list of integers inputed for the Calculation.
	 * @param input	The list of integers inputed for the Calculation.
	 */
	public void setInput(List<Integer> input){
		this.input = input;
	}
	
	/**
	 * Getter for the answer of the Calculation.
	 * @return	The answer attribute.
	 */
	public int getAns(){
		return answer;
	}
	
	/**
	 * Setter for the answer attribute.
	 * @param answer	The answer to the calculation that was
	 * executed.
	 */
	public void setAns(int answer){
		this.answer = answer;
	}
}
