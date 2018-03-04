package com.dreamsmadevisible.kattis.cudoviste;

import java.util.Scanner;

/**
 * Problem definition: https://open.kattis.com/problems/cudoviste
 */
public class Cudoviste {
  private static final int MONSTER_CAR_WIDTH = 2;
  private static final int MONSTER_CAR_HEIGHT = 2;

  private Cudoviste() { }

  private static int howManyCars(SquareType[][] board, int row, int col) {
    int total = 0;
    for (int dx = 0; dx < MONSTER_CAR_WIDTH; dx++) {
      for (int dy = 0; dy < MONSTER_CAR_HEIGHT; dy++) {
        SquareType type = board[row + dx][col + dy];
        if (type == SquareType.BUILDING) {
          return -1;
        } else if (type == SquareType.CAR) {
          total++;
        }
      }
    }
    return total;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int rows = scanner.nextInt();
    int cols = scanner.nextInt();
    scanner.nextLine();

    SquareType[][] board = new SquareType[rows][cols];
    int[] results = new int[5];

    for (int row = 0; row < rows; row++) {
      String rowString = scanner.nextLine();
      for (int col = 0; col < rowString.length(); col++) {
        char ch = rowString.charAt(col);
        switch (ch) {
          case '#': board[row][col] = SquareType.BUILDING; break;
          case 'X': board[row][col] = SquareType.CAR; break;
          case '.': board[row][col] = SquareType.EMPTY; break;
          default: throw new IllegalArgumentException();
        }
      }
    }

    for (int row = 0; row < rows - MONSTER_CAR_WIDTH + 1; row++) {
      for (int col = 0; col < cols - MONSTER_CAR_HEIGHT + 1; col++) {
        int val = howManyCars(board, row, col);
        if (val >= 0) results[val]++;
      }
    }

    for (int result : results) {
      System.out.println(result);
    }
  }
}
