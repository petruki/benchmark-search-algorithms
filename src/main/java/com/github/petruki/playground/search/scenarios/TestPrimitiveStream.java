package com.github.petruki.playground.search.scenarios;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class TestPrimitiveStream {
	
    public static void testObjectForEach(ExecutionPrimitivePlan plan) {
    	for (int i : plan.find)
			searchStream(plan.fixture1, i);
    }
    
	public static boolean searchStream(int[][] matrix, int id) {
		return !(Arrays.stream(matrix)
				.flatMapToInt(rows -> IntStream.of(rows))
				.filter(r -> r == 0).count() > 0);
	}
	
}