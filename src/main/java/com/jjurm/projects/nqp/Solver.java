package com.jjurm.projects.nqp;

/**
 * A class containing the algorithm for solving the N Queens problem. Other classes like Chessboard
 * could be created and used but are omitted for simplicity as they would only cause unnecessary
 * drawback.
 * <p>
 * The algorithms is simple recursive backtracking, keeping track of the number of queens in each
 * column and each diagonal line.
 * </p>
 * 
 * @author JJurM
 */
public class Solver {

  /**
   * The size of the chessboard, i.e. the number of rows and columns.
   */
  private int N;

  /**
   * An array where {@code columnInRow[i]} stores the column index of a queen in the {@code i}-th
   * row.
   */
  private int[] columnInRow;

  /**
   * An array where {@code countInColumn[i]} stores the number of queens currently placed in the
   * {@code i}-th column.
   */
  private int[] countInColumn;

  /**
   * An array where {@code countInPositiveDiagonal[i]} stores the number of queens currently placed
   * in the {@code i}-th positive diagonal.
   */
  private int[] countInPositiveDiagonal;

  /**
   * An array where {@code countInNegativeDiagonal[i]} stores the number of queens currently placed
   * in the {@code i}-th negative diagonal.
   */
  private int[] countInNegativeDiagonal;

  /**
   * Basic constructor that takes the size of the chessboard and constructs a ready to solve the
   * problem.
   * 
   * @param N size of the chessboard
   */
  public Solver(int N) {
    this.N = N;
    this.columnInRow = new int[N];
    this.countInColumn = new int[N];
    this.countInPositiveDiagonal = new int[2 * N - 1];
    this.countInNegativeDiagonal = new int[2 * N - 1];
  }

  /**
   * Solves the chessboard for {@code N} and returns the number of solutions.
   * 
   * @return the number of solutions
   */
  public int solve() {
    return backtrack(0);
  }

  /**
   * Method for recursive backtracking.
   * 
   * @return the number of solutions
   */
  private int backtrack(int row) {

    // check if we already went through all rows
    if (row == N) {
      // hurray, we found a solution
      return 1;
    }

    // we will count the number of solutions to return
    int count = 0;

    // go through all columns in the current row
    for (int column = 0; column < N; column++) {

      // check if it's possible to place a queen here
      if (canBePlaced(row, column)) {

        // place it there
        placeOn(row, column);

        // backtrack deeper
        count += backtrack(row + 1);

        // remove back
        removeFrom(row, column);

      }
    }

    return count;
  }

  /**
   * Determines if a new queen can be placed on the square specified by {@code row} and
   * {@code column}. This method assumes that the algorithms follows the described approach. Hence
   * it can perform the check with time complexity <em>O(0)<em>.
   * 
   * @param row row index
   * @param column column index
   * @return {@code true} if the placement is possible, {@code false} otherwise
   */
  private boolean canBePlaced(int row, int column) {
    return countInColumn[column] == 0
        && countInPositiveDiagonal[getPositiveDiagonalIndex(row, column)] == 0
        && countInNegativeDiagonal[getNegativeDiagonalIndex(row, column)] == 0;
  }

  /**
   * Places a new queen on the square given by {@code row} and {@code column}.
   * 
   * @param row row index
   * @param column column index
   */
  private void placeOn(int row, int column) {
    columnInRow[row] = column;
    countInColumn[column]++;
    countInPositiveDiagonal[getPositiveDiagonalIndex(row, column)]++;
    countInNegativeDiagonal[getNegativeDiagonalIndex(row, column)]++;
  }

  /**
   * Removes a queen from the square given by {@code row} and {@code column}.
   * 
   * @param row row index
   * @param column column index
   */
  private void removeFrom(int row, int column) {
    countInColumn[column]--;
    countInPositiveDiagonal[getPositiveDiagonalIndex(row, column)]--;
    countInNegativeDiagonal[getNegativeDiagonalIndex(row, column)]--;
  }

  /**
   * Returns the index of a positive diagonal which contains the square given by the {@code row} and
   * {@code column} index. Positive diagonal generally goes from bottom left to top right.
   * 
   * @param row row index
   * @param column column index
   * @return index of the positive diagonal
   */
  private int getPositiveDiagonalIndex(int row, int column) {
    return row + column;
  }

  /**
   * Returns the index of a negative diagonal which contains the square given by the {@code row} and
   * {@code column} index. Negative diagonal generally goes from bottom left to top right.
   * 
   * @param row row index
   * @param column column index
   * @return index of the negative diagonal
   */
  private int getNegativeDiagonalIndex(int row, int column) {
    return row - column + N - 1;
  }

}
