package com.dreamsmadevisible.kattis.rationalsequence2;

import java.util.Scanner;

/**
 * Problem definition: https://open.kattis.com/problems/rationalsequence2
 */
public class RationalSequence2 {
  private RationalSequence2() { }

  public static int getSequenceNumber(int numerator, int denominator) {
    if (numerator == denominator) {
      if (numerator != 1) throw new AssertionError();
      return 1;
    } else if (numerator > denominator) {
      return 2 * getSequenceNumber(numerator - denominator, denominator) + 1;
    } else {
      return 2 * getSequenceNumber(numerator, denominator - numerator);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numTests = scanner.nextInt();
    for (int i = 0; i < numTests; i++) {
      int id = scanner.nextInt();
      String fractionString = scanner.nextLine().trim();
      String[] parts = fractionString.split("/");

      int numerator = Integer.parseInt(parts[0]);
      int denominator = Integer.parseInt(parts[1]);
      System.out.println(id + " " + getSequenceNumber(numerator, denominator));
    }
  }
}
