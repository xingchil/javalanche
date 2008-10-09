package de.st.cs.unisb.javalanche.bytecodeMutations.negateJumps.testclasses.jumps;

import junit.framework.TestCase;


public class JumpsTest extends TestCase {

	Jumps jumps = new Jumps();

	// @Test
	public void testMethod1() {
		assertEquals(1, jumps.method1(1));
		assertEquals(-1, jumps.method1(-51));
	}

	// @Test
	public void testMethod2() {
		assertEquals(1, jumps.method2(5));
		assertEquals(0, jumps.method2(0));
		assertEquals(-1, jumps.method2(-9));
	}

	// @Test
	public void testMethod3() {
		assertEquals(-5, jumps.method3(5));
	}

	// @Test
	public void testMethod4() {
		assertEquals(true, jumps.method4(0));
		assertEquals(false, jumps.method4(-8));
	}

	public void testMethod5() {
		jumps.method1(0);
		jumps.method2(0);
		jumps.method3(0);
		jumps.method4(0);
	}
}
