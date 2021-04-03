package com.github.petruki.playground.search.scenarios;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class TestPrimitiveForEach {
	
    public static void testObjectForEach(ExecutionPrimitivePlan plan) {
    	for (int i : plan.find)
			searchForEach(plan.fixture1, i);
    }
    
	public static boolean searchForEach(int[][] matrix, int id) {
		for (int[] rows : matrix) {
			for (int cell : rows) {
				if (cell == id)
					return false;
			}

		}
		return true;
	}
	
}