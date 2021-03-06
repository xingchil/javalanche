///*
// * Copyright (C) 2011 Saarland University
// * 
// * This file is part of Javalanche.
// * 
// * Javalanche is free software: you can redistribute it and/or modify
// * it under the terms of the GNU Lesser Public License as published by
// * the Free Software Foundation, either version 3 of the License, or
// * (at your option) any later version.
// * 
// * Javalanche is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU Lesser Public License for more details.
// * 
// * You should have received a copy of the GNU Lesser Public License
// * along with Javalanche.  If not, see <http://www.gnu.org/licenses/>.
// */
//package de.unisb.cs.st.javalanche.mutation.properties;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
//
//import org.apache.log4j.Logger;
//
//import de.unisb.cs.st.javalanche.mutation.util.MutationUtil;
//
//public class MutationProperties {
//
//	private static Logger logger = Logger.getLogger(MutationProperties.class);
//
//	public static final String PROPERTIES_FILE_KEY = "javalanche.properties.file";
//
//	// public static final String PROPERTIES_FILE = getPropertyOrDefault(
//	// PROPERTIES_FILE_KEY, "javalanche.properties");
//
//	public static final String PROPERTIES_FILE = "javalanche.properties";
//
//	public static final Properties PROPERTIES = getProperties();
//
//	static {
//		logger.info("Loaded log4j configuration from "
//				+ MutationUtil.getLog4jPropertiesLocation());
//	}
//
//	private static Properties getProperties() {
//		Properties properties = new Properties();
//		InputStream is = MutationProperties.class.getClassLoader()
//				.getResourceAsStream(PROPERTIES_FILE);
//		if (is != null) {
//			try {
//				properties.load(is);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			if (properties != null) {
//				logger.debug("Got following properties from file. File: "
//						+ PROPERTIES_FILE + " Properties: "
//						+ properties.keySet());
//			}
//		}
//		return properties;
//	}
//
//	private static final String OUTPUT_DIR_KEY = "javalanche.mutation.output.dir";
//
//	public static final String OUTPUT_DIR = getPropertyOrDefault(
//			OUTPUT_DIR_KEY, "mutation-files");
//
//	private static final String RUN_MODE_KEY = "javalanche.run.mode";
//
//	public static RunMode RUN_MODE = getRunMode();
//
//	public static final String MUTATION_FILE_KEY = "javalanche.mutation.file";
//
//	public static String MUTATION_FILE_NAME = getProperty(MUTATION_FILE_KEY);
//
//	public static String IGNORE_MESSAGES_KEY = "javalanche.ignore.test.messages";
//
//	public static boolean IGNORE_MESSAGES = getPropertyOrDefault(
//			IGNORE_MESSAGES_KEY, true);
//
//	public static String IGNORE_EXCEPTION_TRACES_KEY = "javalanche.ignore.exception.traces";
//
//	public static boolean IGNORE_EXCEPTION_TRACES = getPropertyOrDefault(
//			IGNORE_EXCEPTION_TRACES_KEY, true);
//
//	/**
//	 * 
//	 * The key for the system property that specifies the package prefix of the
//	 * project to mutate
//	 * 
//	 * For example: -Dmutation.package.prefix=org.aspectj
//	 */
//	public static final String PROJECT_PREFIX_KEY = "javalanche.project.prefix";
//
//	public static String PROJECT_PREFIX = getPrefix();
//
//	/**
//	 * The key for the system property that specifies the tests that are used
//	 * for mutation testing.
//	 * 
//	 */
//	public static final String TEST_SUITE_KEY = "javalanche.test.classes";
//
//	public static String TEST_SUITE = getProperty(TEST_SUITE_KEY);
//
//	public static final String TEST_METHODS_KEY = "javalanche.test.methods";
//	public static String TEST_METHODS = getProperty(TEST_METHODS_KEY);
//
//	public static final String CURRENT_MUTATION_KEY = "javalanche.current.mutation";
//
//	public static final String TRACE_BYTECODE_KEY = "javalanche.trace.bytecode";
//
//	public static boolean TRACE_BYTECODE = getPropertyOrDefault(
//			TRACE_BYTECODE_KEY, false);
//
//	public static final String STOP_AFTER_FIRST_FAIL_KEY = "javalanche.stop.after.first.fail";
//
//	public static final boolean STOP_AFTER_FIRST_FAIL = getPropertyOrDefault(
//			STOP_AFTER_FIRST_FAIL_KEY, true);
//
//	private static final String DEFAULT_TIMEOUT_IN_SECONDS_KEY = "javalanche.mutation.default.timeout";
//
//	public static final int DEFAULT_TIMEOUT_IN_SECONDS = getPropertyOrDefault(
//			DEFAULT_TIMEOUT_IN_SECONDS_KEY, 10);
//
//	/**
//	 * The save interval in which the mutation results are written to the
//	 * database.
//	 */
//	private static final String SAVE_INTERVAL_KEY = "javalanche.save.interval";
//	public static final int SAVE_INTERVAL = getPropertyOrDefault(
//			SAVE_INTERVAL_KEY, 50);
//
//	public static final String ENABLE_RIC_KEY = "javalanche.ignore.ric";
//	public static final boolean ENABLE_RIC = getPropertyOrDefault(
//			ENABLE_RIC_KEY, true);
//
//	public static final String ENABLE_NEGATE_JUMPS_KEY = "javalanche.ignore.jumps";
//	public static final boolean ENABLE_NEGATE_JUMPS = getPropertyOrDefault(
//			ENABLE_NEGATE_JUMPS_KEY, true);
//
//	public static final String ENABLE_ARITHMETIC_REPLACE_KEY = "javalanche.ignore.replace";
//	public static final boolean ENABLE_ARITHMETIC_REPLACE = getPropertyOrDefault(
//			ENABLE_ARITHMETIC_REPLACE_KEY, true);
//
//	public static final String ENABLE_REMOVE_CALLS_KEY = "javalanche.ignore.remove.calls";
//	public static final boolean ENABLE_REMOVE_CALLS = getPropertyOrDefault(
//			ENABLE_REMOVE_CALLS_KEY, true);
//
//	public static final String ENABLE_REPLACE_VARIABLES_KEY = "javalanche.ignore.replace.variables";
//	public static boolean ENABLE_REPLACE_VARIABLES = getPropertyOrDefault(
//			ENABLE_REPLACE_VARIABLES_KEY, false);
//
//	public static final File TEST_MAP_FILE = new File(OUTPUT_DIR,
//			"testname-map.xml");
//
//	public static final File EXCLUDE_FILE = new File(OUTPUT_DIR, "exclude.txt");
//
//
//	public static final File TEST_EXCLUDE_FILE = new File(OUTPUT_DIR,
//			"test-exclude.txt"); // TODO other dir
//
//	public static final String JUNIT4_MODE_KEY = "javalanche.junit4";
//
//	public static final boolean JUNIT4_MODE = getPropertyOrDefault(
//			JUNIT4_MODE_KEY, false);
//
//	public static final String JUNIT4_TEST_ADAPTER = "junit.framework.JUnit4TestAdapter";
//
//	public static final String ECLIPSE_RUN_CONFIG_NAME_KEY = "javalanche.eclipse.run.configuration";
//	public static final String ECLIPSE_RUN_CONFIG_NAME = getPropertyOrDefault(
//			ECLIPSE_RUN_CONFIG_NAME_KEY, "no config");
//
//	public static final String CONNECTION_DATA_FILE = OUTPUT_DIR
//			+ "/connections.xml";
//
//	public static final String INHERITANCE_DATA_FILE = OUTPUT_DIR
//			+ "/inheritance.xml";
//
//	public static final String TEST_PERMUTATIONS_KEY = "javalanche.test.permutations";
//
//	public static final int TEST_PERMUTATIONS = getPropertyOrDefault(
//			TEST_PERMUTATIONS_KEY, 10);
//
//	public static final String SINGLE_TASK_MODE_KEY = "javalanche.single.task.mode";
//
//	public static boolean SINGLE_TASK_MODE = getPropertyOrDefault(
//			SINGLE_TASK_MODE_KEY, false);
//
//	public static final String USE_THREAD_STOP_KEY = "javalanche.use.thread.stop";
//
//	public static final boolean USE_THREAD_STOP = getPropertyOrDefault(
//			USE_THREAD_STOP_KEY, true);
//
//	public static final int getPropertyOrDefault(String key, int defaultValue) {
//		String result = getPropertyOrDefault(key, defaultValue + "");
//		return Integer.parseInt(result);
//	}
//
//	public static boolean getPropertyOrDefault(String key, boolean defaultValue) {
//		String property = getProperty(key);
//		if (property != null) {
//			String propertyTrimmed = property.trim().toLowerCase();
//			if (propertyTrimmed.equals("true") || propertyTrimmed.equals("yes")) {
//				return true;
//			} else if (propertyTrimmed.equals("false")
//					|| propertyTrimmed.equals("no")) {
//				return false;
//			}
//		}
//		return defaultValue;
//	}
//
//	private static RunMode getRunMode() {
//		String runModeString = getProperty(RUN_MODE_KEY);
//		if (runModeString != null) {
//			runModeString = runModeString.toLowerCase();
//			for (RunMode runMode : RunMode.values()) {
//				if (runMode.getKey().equals(runModeString)) {
//					return runMode;
//				}
//			}
//		}
//		return RunMode.OFF;
//	}
//
//	private static final String getPropertyOrDefault(String key,
//			String defaultValue) {
//		String result = getProperty(key);
//		if (result == null) {
//			result = defaultValue;
//		}
//		return result;
//	}
//
//	private static String getProperty(String key) {
//		String result = null;
//		if (System.getProperty(key) != null) {
//			result = System.getProperty(key);
//		}
//		// no else if - property may also be null
//		if (result == null && PROPERTIES.containsKey(key)) {
//			result = PROPERTIES.getProperty(key);
//		}
//		logger.info(String.format("Got property: key=%s  ,  value=%s", key,
//				result));
//		return result;
//	}
//
//	private static String getPrefix() {
//		String project_prefix = getProperty(PROJECT_PREFIX_KEY);
//		if (project_prefix == null || project_prefix.length() == 0) {
//			logger.warn("No project prefix found (Property: "
//					+ PROJECT_PREFIX_KEY + " not set)");
//		}
//		return project_prefix;
//	}
//
//	public static void checkProperty(String key) {
//		String property = System.getProperty(key);
//		if (property == null) {
//			throw new IllegalStateException("Property not specified. Key: "
//					+ key);
//		}
//	}
//
//	/**
//	 * 
//	 * Debugging Properties
//	 * 
//	 * */
//	public static String INSERT_ORIGINAL_INSTEAD_OF_MUTATION_KEY = "javalanche.debug.insert.original.code";
//
//	public static boolean INSERT_ORIGINAL_INSTEAD_OF_MUTATION = getPropertyOrDefault(
//			INSERT_ORIGINAL_INSTEAD_OF_MUTATION_KEY, false);
//
//	public static final boolean QUERY_DB_BEFORE_START = false;
//
//	/**
//	 * When set true, System.println statements will be inserted that signal
//	 * whether a mutation is covered.
//	 */
//	public static final String MUTATION_PRINT_STATEMENTS_ENABLED_KEY = "javalanche.mutation.print.statements";
//
//	public static final boolean MUTATION_PRINT_STATEMENTS_ENABLED = getPropertyOrDefault(
//			MUTATION_PRINT_STATEMENTS_ENABLED_KEY, false);
//
//	public static final String PROJECT_SOURCE_DIR_KEY = "javalanche.project.source.dir";
//
//	public static final String PROJECT_SOURCE_DIR = getProperty(PROJECT_SOURCE_DIR_KEY);
//
//	public static final String IGNORE_PREFIX_KEY = "javalanche.ignore.prefix";
//
//	public static String IGNORE_PREFIX = getPropertyOrDefault(
//			IGNORE_PREFIX_KEY, "");
//
//	public static final String MUTATION_TIME_LIMIT_MESSAGE = "Mutation exceeded time limit";
//
//	public static final String EXCLUDED_TESTS_KEY = "javalanche.excluded.tests";
//	public static final String EXCLUDED_TESTS = getPropertyOrDefault(
//			EXCLUDED_TESTS_KEY, null);
//
//
//
// }
