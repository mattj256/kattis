package com.dreamsmadevisible.kattis.dyslectionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Problem definition: https://open.kattis.com/problems/dyslectionary
 */
public class Dyslectionary implements Comparator<String> {
  private boolean first = true;

  public Dyslectionary() { }

  public void processWords(List<String> words) {
    if (!first) System.out.println();
    first = false;
    int maxLength = getMaxLength(words);
    Collections.sort(words, this);
    for (String word : words) {
      System.out.printf("%" + maxLength + "s\n", word);
    }
  }

  @Override
  public int compare(String first, String second) {
    return reverse(first).compareTo(reverse(second));
  }

  private int getMaxLength(List<String> words) {
    int max = 0;
    for (String word : words) {
      if (word.length() > max) max = word.length();
    }
    return max;
  }

  private String reverse(String input) {
    return new StringBuilder(input).reverse().toString();
  }

  public static void main(String[] args) {
    Dyslectionary lex = new Dyslectionary();
    Scanner scanner = new Scanner(System.in);
    List<String> words = new ArrayList<>();
    while (scanner.hasNextLine()) {
      String word = scanner.nextLine();
      if (word.isEmpty()) {
        lex.processWords(words);
        words.clear();
      } else {
        words.add(word);
      }
    }
    if (!words.isEmpty()) lex.processWords(words);
  }
}
