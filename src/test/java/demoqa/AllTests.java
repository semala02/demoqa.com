package demoqa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DemoQATest1.class, DemoQATest2.class, DemoQATest3.class, DemoQATest4.class, DemoQATest5.class,
		DemoQATest6.class, DemoQATest7.class, DemoQATest8.class })
public class AllTests {

}
