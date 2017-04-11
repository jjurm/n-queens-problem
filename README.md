# N-Queens Problem

A solution to the *N-Queens problem* written in Java. The task is to compute the number of different placements of *N* chess queens on an *N×N* chessboard in a way such that no two of them attack each other.

## Algorithm

This algorithm uses simple recursive backtracking (i.e. depth-first search), keeping track of the number of queens in each column and each diagonal line. The time complexity is exponential due to the use of backtracking. The program works without storing the state of the whole chessboard in a two-dimensional array and therefore has only a linear space complexity.

## Language

Java was chosen to best demonstrate the beauty of a neat and well-documented code and to utilise tools like *Maven* and *JUnit*.
