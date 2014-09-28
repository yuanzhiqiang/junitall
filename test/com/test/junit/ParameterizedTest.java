package com.test.junit;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTest {

	
	private int expected;
	private int input1;
	private int input2;
	@SuppressWarnings("rawtypes")
	@Parameters
	public static Collection prepareData() {
		return Arrays.asList(new Object[][] {{3,1,2},{0,0,0},{-4,-1,-3},{6,-3,9}});
	}
	
	public ParameterizedTest(int expected, int input1, int input2){
		this.expected = expected;
		this.input1 = input1;
		this.input2 = input2;
	}
	
	@Test
	public void testAdd(){
		Calculator cal = new Calculator();
		Assert.assertEquals(expected, cal.add(input1, input2));
	}
}
