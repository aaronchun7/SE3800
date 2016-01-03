package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import calculator.Calculator;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class testCalculator {

//	@DataProvider(name = "validNumbers")
//	public static Object[][] createValidData(){
//		return new Object [][] {
//			{new ArrayList<Integer>(){{add(1);add(2);add(3);
//			}},},
//			{new ArrayList<Integer>(){{add(Integer.MAX_VALUE);add(1);
//			}},},
//			{new ArrayList<Integer>(){{add(Integer.MIN_VALUE);add(1);
//			}},},
//			{new ArrayList<Integer>(){{add(10);add(0);
//			}},},
//			{new ArrayList<Integer>(){{add(4);add(-5);add(6);
//			}},}};
//	}

	/**
	 * Tests add() method.
	 * @author chuna
	 */
	@Test//(dataProvider = "validNumbers")
	public void testAdd(){
		List <Integer> l = new ArrayList<Integer>(){{add(1);add(2);add(3);}};
		assert(Calculator.add(l) == 6);
		l = new ArrayList<Integer>(){{add(Integer.MAX_VALUE);add(1);}};
		assert(Calculator.add(l) == Integer.MAX_VALUE);
		l = new ArrayList<Integer>(){{add(4);add(-5);add(6);}};
		assert(Calculator.add(l) == 5);
	}

	/**
	 * Tests sub() method.
	 * @author kuczynskij
	 */
	@Test
	public void testSub(){

	}

	/**
	 * Tests mult() method.
	 * @author chuna
	 */
	@Test
	public void testMult(){

	}

	/**
	 * Tests div() method.
	 * @author kuczynskij
	 */
	@Test
	public void testDiv(){

	}

	/**
	 * Tests hist() method.
	 * @author chuna
	 */
	@Test
	public void testHist(){

	}

	/**
	 * Tests clear() method.
	 * @author kuczynskij
	 */
	@Test
	public void testClear(){

	}

	/**
	 * Tests reuse() method.
	 * @author chuna
	 */
	@Test
	public void testReuse(){

	}

	/**
	 * Tests wumbo() method.
	 * @author kuczynskij
	 */
	@Test
	public void testWumbo(){

	}
}
