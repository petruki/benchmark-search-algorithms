package com.github.petruki.playground.search.scenarios;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class TestObjectForEach {
	
    public static void testObjectForEach(ExecutionObjectPlan plan) {
    	for (int i : plan.find)
			searchForEach(plan.fixture1, i);
    }
    
	public static boolean searchForEach(Object[][] matrix, Object id) {
		for (Object[] rows : matrix) {
			for (Object cell : rows) {
				if (cell.equals(id))
					return false;
			}

		}
		return true;
	}
	
}