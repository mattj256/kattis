package com.dreamsmadevisible.kattis.beekeeper;

import java.util.Scanner;

/**
 * Problem definition: https://open.kattis.com/problems/beekeeper
 */
public class Beekeeper {

  private static int getDoubleLetterCount(String word) {
    int count = 0;
    for (int i = 1; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u' && ch != 'y') continue;
      if (ch == word.charAt(i - 1)) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      int numWords = scanner.nextInt();
      scanner.nextLine();
      if (numWords == 0) break;

      int maxScore = -1;
      String maxWord = "";
      for (int i = 0; i < numWords; i++) {
        String word = scanner.nextLine();
        int currentScore = getDoubleLetterCount(word);
        if (currentScore > maxScore) {
          maxScore = currentScore;
          maxWord = word;
        }
      }
      System.out.println(maxWord);
    }
  }
}
