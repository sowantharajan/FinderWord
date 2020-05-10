package com.find.testing;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.find.word.Finder;

public class MyAssertArrayEqualsBasicTest {
	@Test
	public void myTestMethod() {
		// Basic Test case

		// assume that the below array represents expected result
		String[] expectedOutput = { "app" };
		Finder finder2 = new Finder(new String[] { "app", "fgh", "bvc" });
		// assume that the below array is returned from the method to be tested.
		String[] methodOutput = finder2.find("app");
		assertArrayEquals(expectedOutput, methodOutput);	
		String[] unExpectedOutput = { "fgh" };
		//assertArrayEquals(unExpectedOutput, methodOutput);
	}
}
