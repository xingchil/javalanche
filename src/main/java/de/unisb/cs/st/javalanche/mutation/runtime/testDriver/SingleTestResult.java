package de.unisb.cs.st.javalanche.mutation.runtime.testDriver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import de.unisb.cs.st.javalanche.mutation.results.MutationTestResult;
import de.unisb.cs.st.javalanche.mutation.results.TestMessage;

/**
 * Sumarrizes the results of one Test.
 *
 * @author David Schuler
 *
 */
public class SingleTestResult {

	/**
	 * Enumeration that signals if a test case passed, failed or caused an
	 * error.
	 */
	public enum TestOutcome {
		PASS, FAIL, ERROR
	};

	/**
	 * The outcome of this test.
	 */
	public TestOutcome result;

	/**
	 * The passing/failing message of this test.
	 */
	public TestMessage testMessage;

	/**
	 * Creates a new SingleTestResult with given parameters.
	 *
	 * @param testCaseName
	 *            the name of the test case
	 * @param message
	 *            the message for this test
	 * @param pass
	 *            signals wheter the test passed or not
	 * @param duration
	 *            the time the test took
	 */
	public SingleTestResult(String testCaseName, String message, boolean pass,
			long duration) {
		super();
		this.result = pass ? TestOutcome.PASS : TestOutcome.FAIL;
		this.testMessage = new TestMessage(testCaseName, message, duration);
	}

	/**
	 * Transforms a collection of SingleTestResults to a MutationTestResult
	 *
	 * @param testResults
	 *            the single test results for one mutation
	 * @return the mutation test result.
	 */
	public static MutationTestResult toMutationTestResult(
			Collection<SingleTestResult> testResults) {
		List<TestMessage> passing = new ArrayList<TestMessage>();
		List<TestMessage> failing = new ArrayList<TestMessage>();
		List<TestMessage> errors = new ArrayList<TestMessage>();
		boolean touched = false;
		for (SingleTestResult tsr : testResults) {
			if (tsr.testMessage.isHasTouched()) {
				touched = tsr.testMessage.isHasTouched();
			}
			if (tsr.result == TestOutcome.PASS) {
				passing.add(tsr.testMessage);
			} else if (tsr.result == TestOutcome.ERROR) {
				errors.add(tsr.testMessage);
			} else {
				failing.add(tsr.testMessage);
			}
		}
		MutationTestResult r = new MutationTestResult(passing, failing, errors,
				touched);
		return r;
	}

	/**
	 * Used to signal whether the mutation was touched by this test.
	 *
	 * @param b
	 *            signals whether the mutation was touched by this test
	 */
	public void setTouched(boolean b) {
		testMessage.setHasTouched(b);
	}

	/**
	 * Return the duration of this test.
	 *
	 * @return the duration of this test
	 */
	public long getDuration() {
		return testMessage.getDuration();
	}

	/**
	 * Return true, if the test passed.
	 *
	 * @return true, if the test passed
	 */
	public boolean hasPassed() {
		return result == TestOutcome.PASS;
	}

	/**
	 * Return the test message of this test.
	 *
	 * @return the test message of this test
	 */
	public TestMessage getTestMessage() {
		return testMessage;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return result + "  " + testMessage.toString();
	}
}
