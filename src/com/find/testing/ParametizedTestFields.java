package com.find.testing;
	
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.find.word.Finder;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class ParametizedTestFields {

    @Parameter(0)
    public String findWord;
    @Parameter(1)
    public String[] inputArray;
    @Parameter(2)
    public String[] result;

 // creates the test data
    @Parameters
    public static Collection<Object[]> data() {
    	Object[][] data = new Object[][] { { "asd",new String[] {"ads","fgh","bvc"},new String[] {"ads"}},
    		{ "dfg",new String[] {"dfg","deb","gfd"},new String[] {"dfg","gfd"}}, 
    		{ "pkl",new String[] {"pkl","plk","lkp"},new String[] {"pkl","plk","lkp"}}};
        return Arrays.asList(data);
    }


    @Test
    public void testFindWord() {
    	Finder finder = new Finder(inputArray);
    	//System.out.println(inputArray);
    	for (String foundWord : finder.find(findWord)) {
			// Printed output values
			System.out.println("Each matched words in the arrays: " + foundWord);
		}
    	for (String resultWord : result) {
			System.out.println("resultWord in the arrays: " + resultWord);
		}
    	assertArrayEquals("Result", result, finder.find(findWord));
    	
    }

}