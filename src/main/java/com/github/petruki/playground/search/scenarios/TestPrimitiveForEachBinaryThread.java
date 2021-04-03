package com.github.petruki.playground.search.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Semaphore;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class TestPrimitiveForEachBinaryThread {
	
    public static void testPrimitiveThread(ExecutionPrimitivePlan plan) {
    	searchForEachBinaryThread(plan.find, plan.fixture1);
    }
    
	public static int searchForEachBinaryThread(int[] find, int[][] fixture1) {
		int threads = 8;
		int permits = threads;

		final Semaphore semaphore = new Semaphore(permits);
		int output = 0;
		
		int endAt = find.length/threads;
		int portion = find.length/threads;
		int startAt = 2;
		final ArrayList<SearchPrimitiveThread> listOutput = new ArrayList<SearchPrimitiveThread>();

		try {
			SearchPrimitiveThread runner;
			while (threads-- > 0) {
				semaphore.acquire();
				runner = new SearchPrimitiveThread(startAt, endAt, find, fixture1, semaphore);
				listOutput.add(runner);
				runner.start();

				startAt = endAt + 1;
				endAt = endAt + portion - 1;
			}

			semaphore.acquire(permits);
			for (SearchPrimitiveThread primeThread : listOutput)
				output += primeThread.getOutput();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return output;
	}
	
	static class SearchPrimitiveThread extends Thread {

		private int start, end, output;
		private Semaphore semaphore;
		private int[] find;
		private int[][] fixture1;

		public SearchPrimitiveThread(
				int start, int end, final 
				int[] find, int[][] fixture1,
				final Semaphore semaphore) {
			this.start = start;
			this.end = end;
			this.find = find;
			this.fixture1 = fixture1;
			this.output = 0;
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			for (int i = start; i <= end; i++) {
				if (search(find[i]))
					output++;
			}
			
			this.semaphore.release();
		}
		
		public boolean search(int id) {
			for (int[] rows : fixture1) {
				if (Arrays.binarySearch(rows, id) > -1) {
					return false;
				}
			}
			
			return true;
		}
		
		public int getOutput() {
			return this.output;
		}

	}
	
}