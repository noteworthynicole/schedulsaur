package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestClass.class, TestSection.class, TestTimes.class, TestDoubleTimes.class })
public class AllTests {

}
