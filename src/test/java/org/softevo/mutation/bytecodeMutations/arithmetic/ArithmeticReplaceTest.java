package org.softevo.mutation.bytecodeMutations.arithmetic;

import junit.framework.TestResult;
import junit.framework.TestSuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.softevo.mutation.bytecodeMutations.ByteCodeTestUtils;
import org.softevo.mutation.bytecodeMutations.arithmetic.testClass.Arithmetic;
import org.softevo.mutation.bytecodeMutations.arithmetic.testClass.ArithmeticTest;
import org.softevo.mutation.testsuite.SelectiveTestSuite;

public class ArithmeticReplaceTest {

	private static final Class TEST_CLASS = Arithmetic.class;

	private static final String TEST_CLASS_TYPE = TEST_CLASS.getName();

	private static final String UNITTEST_CLASS_TYPE = ArithmeticTest.class
			.getName();

	private static final String TEST_CLASS_FILENAME = ByteCodeTestUtils.getFileNameForClass(TEST_CLASS);


	private static String[] testCaseNames = ByteCodeTestUtils
			.generateTestCaseNames(UNITTEST_CLASS_TYPE, 5);

	private static final int[] linenumbers = { 6, 10, 14, 19, 24 };

	@Before
	public void setup() {
		ByteCodeTestUtils.generateCoverageData(TEST_CLASS_TYPE, testCaseNames,
				linenumbers);
		ByteCodeTestUtils.deleteTestMutationResult(TEST_CLASS_TYPE);
		ByteCodeTestUtils.generateTestDataInDB(TEST_CLASS_FILENAME);
	}

	@After
	public void tearDown() {
		ByteCodeTestUtils.deleteTestMutationResult(TEST_CLASS_TYPE);
	}

	@Test
	public void runTests() {
		SelectiveTestSuite selectiveTestSuite = new SelectiveTestSuite();
		TestSuite suite = new TestSuite(ArithmeticTest.class);
		selectiveTestSuite.addTest(suite);
		@SuppressWarnings("unused")
		Arithmetic a = new Arithmetic();
		selectiveTestSuite.run(new TestResult());
	}

}