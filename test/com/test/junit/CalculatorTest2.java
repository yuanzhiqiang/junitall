package com.test.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest2
{
	private Calculator cal;

	@Before
	public void init()
	{
		cal = new Calculator();
		System.out.println("init invoked!");
	}

	@After
	public void destroy()
	{
		System.out.println("destroy invoked!");
	}

	@BeforeClass
	public static void globalInit()
	{
		System.out.println("globalInit invoked!");
	}

	@AfterClass
	public static void globalDestroy()
	{
		System.out.println("globalDestroy invoked!");
	}

	@Test
	public void myAdd()
	{
		int result = cal.add(1, 2);

		assertEquals(3, result);
	}

	@Test
	public void myMinus()
	{
		int result = cal.minus(1, 2);

		assertEquals(-1, result);
	}

	@Test
	public void myMultiply()
	{
		int result = cal.multiply(2, 3);

		assertEquals(6, result);
	}

	@Test
	public void myDivide()
	{
		try
		{
			int result = cal.divide(6, 5);

			assertEquals(1, result);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Test(expected = Exception.class)
	public void myDivide2() throws Exception
	{
		cal.divide(1, 0);
	}
	
	@Test(timeout = 100)
	public void myDivide3()
	{
		try
		{
			cal.divide(4,2);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
