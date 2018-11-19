package com.nixsolutions.barchenko.practice10;

import interfaces.junit.JunitTester;
import junit.framework.JUnit4TestAdapter;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ArrayCollectionImplTest.class,
        ArrayIteratorImplTest.class})
public class JunitTesterImpl implements JunitTester {

    @Override
    public TestSuite suite() {
        TestSuite testSuite = new TestSuite();
        testSuite.addTestSuite(ArrayIteratorImplTest.class);
        testSuite.addTest(new JUnit4TestAdapter(ArrayCollectionImplTest.class));
        return testSuite;
    }
}
