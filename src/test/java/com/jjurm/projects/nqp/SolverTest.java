package com.jjurm.projects.nqp;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Test written to check the correctness of the {@link Solver} class.
 * 
 * @author JJurM
 */
@RunWith(Parameterized.class)
public class SolverTest {

  /**
   * Parameters of the test, the correct solutions to a few small values of {@code N}.
   * 
   * @return collection of parameters
   */
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays
        .asList(new Object[][] {{1, 1}, {2, 0}, {3, 0}, {4, 2}, {5, 10}, {6, 4}, {7, 40}, {8, 92}});
  }

  /**
   * Solver constructed with a particular parameter {@code N}
   */
  private Solver solver;

  /**
   * Expected result
   */
  private int expected;

  /**
   * Parametrised constructor.
   * 
   * @param N size of the chessboard
   * @param expected expected result
   */
  public SolverTest(int N, int expected) {
    this.solver = new Solver(N);
    this.expected = expected;
  }

  /**
   * Checks if the algorithms gives correct results for some small {@code N}s.
   */
  @Test
  public void testResult() {
    assertEquals(expected, solver.solve());
  }

}
