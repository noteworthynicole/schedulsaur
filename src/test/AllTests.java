package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestClass.class, TestSection.class, TestTimes.class, TestDoubleTimes.class, TestGenerateSchedules.class, TestDatabaseRead.class, TestDatabaseWrite.class, TestPrerequisites.class })
public class AllTests {

}
