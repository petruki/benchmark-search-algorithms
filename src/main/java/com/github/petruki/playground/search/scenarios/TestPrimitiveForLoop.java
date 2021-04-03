package com.github.petruki.playground.search.scenarios;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class TestPrimitiveForLoop {
	
    public static void testObjectForEach(ExecutionPrimitivePlan plan) {
    	for (int i : plan.find)
			searchForLoop(plan.fixture1, i);
    }
    
	public static boolean searchForLoop(int[][] matrix, int id) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == id)
					return false;
			}
		}
		return true;
	}
	
}