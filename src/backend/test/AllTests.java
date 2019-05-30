package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestTimeSuite.class, TestDatabaseSuite.class, TestCourseSuite.class, TestPrereqSuite.class, TestLoop.class })

public class AllTests {

}
