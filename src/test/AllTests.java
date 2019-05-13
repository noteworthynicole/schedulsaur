package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ test.TestClass.class, test.TestSection.class, test.TestTimes.class, test.TestDoubleTimes.class, test.TestGenerateSchedules.class, test.TestDatabase.class })
public class AllTests {

}

