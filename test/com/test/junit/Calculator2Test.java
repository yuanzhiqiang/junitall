package com.test.junit;

import java.lang.reflect.Method;

import junit.framework.Assert;

import org.junit.Test;

public class Calculator2Test {

	@Test
	public void testAdd() {

		try {
			Class<Calculator2> clazz = Calculator2.class;
			Method method = clazz.getDeclaredMethod("add", new Class[] { int.class, int.class });
			method.setAccessible(true);
			Object result = method.invoke(clazz.newInstance(), new Object[]{1,2});
			Assert.assertEquals(3, result);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
