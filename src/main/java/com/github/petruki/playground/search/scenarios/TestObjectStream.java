package com.github.petruki.playground.search.scenarios;

import java.util.Arrays;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class TestObjectStream {
	
    public static void testObjectStream(ExecutionObjectPlan plan) {
    	for (int i : plan.find)
			searchStream(plan.fixture1, i);
    }
    
	public static boolean searchStream(Object[][] matrix, Object id) {
		return !(Arrays.stream(matrix)
				.flatMap(rows -> Stream.of(rows))
				.filter(r -> r.equals(id)).count() > 0);
	}
	
}