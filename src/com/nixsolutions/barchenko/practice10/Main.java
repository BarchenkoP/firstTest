package com.nixsolutions.barchenko.practice10;

import interfaces.junit.JunitTester;
import junit.framework.TestResult;
import junit.framework.TestSuite;

public class Main {
    public static void main(String[] args) {
        JunitTester junitTester = new JunitTesterImpl();
        TestSuite suite = junitTester.suite();
        TestResult result = new TestResult();
        suite.run(result);
        System.out.println("suite count = " + suite.countTestCases());
    }
}
