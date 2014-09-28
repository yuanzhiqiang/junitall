package com.test.junit;

import com.test.junit.Calculator;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * ��junit3.8�в��������Ҫ�̳�TestCase����
 * 
 * keep the bar green to keep the code clean
 * 
 * ��Ԫ���Բ���֤�����ǶԵģ�����֤����û�д���
 */
public class CalculatorTest extends TestCase
{
	/**
	 * ��junit3.8�У����Է�����������ԭ��
	 * 1��public��
	 * 2��void��
	 * 3���޷�������
	 * 4���������Ʊ�����test��ͷ
	 * 
	 * Dont't Repeat Yourself
	 */
	
	private Calculator cal;
	
	public void setUp()
	{
		cal = new Calculator();
	}
	
	public void tearDown()
	{
		
	}
	
	public void testAdd()
	{
		int result = cal.add(1,2);
		
		//����: assert
		
		Assert.assertEquals(3,result);
	}
	
	public void testMinus()
	{
		int result = cal.minus(1,2);
		
		//����
		
		Assert.assertEquals(-1,result);
	}
	
	public void testMultiply()
	{
		int result = cal.multiply(2,3);
		
		//����
		
		Assert.assertEquals(6,result);
	}
	
	public void testDivide()
	{
		int result = 0;
		
		try
		{
			result = cal.divide(6,4);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
			Assert.fail();
		}
		
		//����
		
		Assert.assertEquals(1,result);
	}
	
	public void testDivide2()
	{
		Throwable tx = null;
		
		try
		{
			cal.divide(4,0);
			
			Assert.fail();
		}
		catch(Exception ex)
		{
			tx = ex;
		}
		
		Assert.assertNotNull(tx);
		
		Assert.assertEquals(Exception.class,tx.getClass());
		
		Assert.assertEquals("��������Ϊ�㣡",tx.getMessage());
	}
	
	
	
	
	
}
