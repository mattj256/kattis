package com.dreamsmadevisible.kattis.simonsays;

import java.util.Scanner;

/**
 * Problem definition: https://open.kattis.com/problems/simonsays
 */
public class SimonSays {
  private static String SIMON_SAYS = "Simon says";
  private static int SIMON_SAYS_LENGTH = SIMON_SAYS.length();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    scanner.nextLine(); // Ignore newline after the previous value.
    for (int i = 0; i < num; i++) {
      String sentence = scanner.nextLine();
      if (sentence.startsWith(SIMON_SAYS)) {
        System.out.println(sentence.substring(SIMON_SAYS_LENGTH, sentence.length()));
      }
    }
  }
}
