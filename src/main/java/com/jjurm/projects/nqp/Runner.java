package com.jjurm.projects.nqp;

/**
 * The executable class to test {@link Solver}.
 * 
 * @author JJurM
 */
public class Runner {

  /**
   * The only executable method. The first argument must be the number {@code N}.
   * 
   * @param args list of program arguments
   */
  public static void main(String[] args) {

    // check if there are any arguments at all
    if (args.length == 0) {
      System.out.println("You must provide N");
      return;
    }

    // parse the integer or print an error
    int N;
    try {
      N = Integer.parseInt(args[0]);
    } catch (NumberFormatException e) {
      System.out.println("The argument must be a number");
      return;
    }

    // create Solver and run the algorithm
    Solver solver = new Solver(N);
    int result = solver.solve();

    // print the result
    System.out.println("Result: " + result);

  }

}
