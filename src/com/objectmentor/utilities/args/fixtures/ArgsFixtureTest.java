package com.objectmentor.utilities.args.fixtures;

import fitnesse.runner.TestRunner;
import junit.framework.TestCase;

public class ArgsFixtureTest extends TestCase {
  public void testAcceptanceTests() throws Exception {
    TestRunner runner = new TestRunner();
    runner.run(new String[]{"localhost", "80", "FrontPage.GetOpt"});
    assertEquals(0, runner.exitCode());
  }
}
