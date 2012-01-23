package com.xurmo.toi;

import org.junit.Test;

import junit.framework.TestCase;

public class ProcessTest extends TestCase {

	private Process process;
	private Process process2;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testProcess() {
		process = new Process(3);
		// System.out.println(process.tower0.getRings().get(0).getiD());

		for (Ring ring : process.tower0.getRings()) {
			System.out.println(ring.getiD());
		}

		System.out.println("=============");

		System.out.println(process.tower1.NumberOfRings());
		System.out.println(process.tower2.NumberOfRings());
	}

	@Test
	public void testMovebyAlg() {
		process = new Process(3);
		process.viewAllRings();
		int i = 0;
		
		// 1
		process.performOddMove();
		process.viewAllRings();
		//2
		process.performEvenMove();
		process.viewAllRings();
		//3
		process.performOddMove();
		process.viewAllRings();
		//4
		process.performEvenMove();
		process.viewAllRings();
		//5
		process.performOddMove();
		process.viewAllRings();
//		//6
		process.performEvenMove();
		process.viewAllRings();
		//7
		process.performOddMove();
		process.viewAllRings();
		//8
		process.performEvenMove();
//		process.viewAllRings();
		//9
//		process.performOddMove();
//		process.viewAllRings();
		//10
//		process.performEvenMove();
//		process.viewAllRings();
		
		
	
	}

	@Test
	public void testGame() {
		process2 = new Process(7);
		
		System.out.println("&&&&");
		process2.viewAllRings();
		
		process2.MovebyAlg(1);
	}

}
