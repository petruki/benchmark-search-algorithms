package com.github.petruki.playground.search;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.github.petruki.playground.search.scenarios.ExecutionObjectPlan;
import com.github.petruki.playground.search.scenarios.ExecutionPrimitivePlan;
import com.github.petruki.playground.search.scenarios.TestObjectForEach;
import com.github.petruki.playground.search.scenarios.TestObjectForEachBinary;
import com.github.petruki.playground.search.scenarios.TestObjectForEachBinaryThread;
import com.github.petruki.playground.search.scenarios.TestObjectForLoop;
import com.github.petruki.playground.search.scenarios.TestObjectStream;
import com.github.petruki.playground.search.scenarios.TestPrimitiveForEach;
import com.github.petruki.playground.search.scenarios.TestPrimitiveForEachBinary;
import com.github.petruki.playground.search.scenarios.TestPrimitiveForEachBinaryThread;
import com.github.petruki.playground.search.scenarios.TestPrimitiveForLoop;
import com.github.petruki.playground.search.scenarios.TestPrimitiveStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
@Measurement(iterations = 1, time = 1)
@Warmup(iterations = 1, time = 1)
public class BenchmarkRunner {
	
	@Benchmark
    public void testObjectForEach(ExecutionObjectPlan plan) {
		TestObjectForEach.testObjectForEach(plan);
    }
	
	@Benchmark
    public void testObjectForLoop(ExecutionObjectPlan plan) {
		TestObjectForLoop.testObjectForLoop(plan);
    }
	
	@Benchmark
    public void testObjectForEachBinary(ExecutionObjectPlan plan) {
		TestObjectForEachBinary.testObjectForEachBinary(plan);
    }
	
	@Benchmark
    public void testObjectStream(ExecutionObjectPlan plan) {
		TestObjectStream.testObjectStream(plan);
    }
	
	@Benchmark
    public void testObjectForEachBinary8Threads(ExecutionObjectPlan plan) {
		TestObjectForEachBinaryThread.testObjectThread(plan);
    }
	
	@Benchmark
    public void testPrimitiveForEach(ExecutionPrimitivePlan plan) {
		TestPrimitiveForEach.testObjectForEach(plan);
    }
	
	@Benchmark
    public void testPrimitiveForLoop(ExecutionPrimitivePlan plan) {
		TestPrimitiveForLoop.testObjectForEach(plan);
    }
	
	@Benchmark
    public void testPrimitiveForEachBinary(ExecutionPrimitivePlan plan) {
		TestPrimitiveForEachBinary.testObjectForEach(plan);
    }
	
	@Benchmark
    public void testPrimitiveStream(ExecutionPrimitivePlan plan) {
		TestPrimitiveStream.testObjectForEach(plan);
    }
	
	@Benchmark
    public void testPrimitiveForEachBinary8Threads(ExecutionPrimitivePlan plan) {
		TestPrimitiveForEachBinaryThread.testPrimitiveThread(plan);
    }
	
    public static void main(String[] args) throws Exception {
    	Options opt = new OptionsBuilder()
                .include(BenchmarkRunner.class.getSimpleName())
                .build();
    	
    	new Runner(opt).run();
    }

}
