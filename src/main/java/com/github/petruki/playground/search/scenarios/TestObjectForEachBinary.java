package com.github.petruki.playground.search.scenarios;

import java.util.Arrays;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class TestObjectForEachBinary {
	
    public static void testObjectForEachBinary(ExecutionObjectPlan plan) {
    	for (int i : plan.find)
			searchForEachBinary(plan.fixture1, i);
    }
    
	public static boolean searchForEachBinary(Object[][] matrix, Object id) {
		for (Object[] rows : matrix) {
			if (Arrays.binarySearch(rows, id) > -1) {
				return false;
			}
		}
		return true;
	}
	
}