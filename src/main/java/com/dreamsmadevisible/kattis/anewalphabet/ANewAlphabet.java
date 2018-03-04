package com.dreamsmadevisible.kattis.anewalphabet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem definition: https://open.kattis.com/problems/anewalphabet
 */
public class ANewAlphabet {
  private final Map<Character, String> letterMap = new HashMap<>();

  public ANewAlphabet() {
    init();
  }

  protected void init() {
    letterMap.put('a', "@");
    letterMap.put('b', "8");
    letterMap.put('c', "(");
    letterMap.put('d', "|)");
    letterMap.put('e', "3");
    letterMap.put('f', "#");
    letterMap.put('g', "6");
    letterMap.put('h', "[-]");
    letterMap.put('i', "|");
    letterMap.put('j', "_|");
    letterMap.put('k', "|<");
    letterMap.put('l', "1");
    letterMap.put('m', "[]\\/[]");
    letterMap.put('n', "[]\\[]");
    letterMap.put('o', "0");
    letterMap.put('p', "|D");
    letterMap.put('q', "(,)");
    letterMap.put('r', "|Z");
    letterMap.put('s', "$");
    letterMap.put('t', "']['");
    letterMap.put('u', "|_|");
    letterMap.put('v', "\\/");
    letterMap.put('w', "\\/\\/");
    letterMap.put('x', "}{");
    letterMap.put('y', "`/");
    letterMap.put('z', "2");
  }

  public String translate(String input) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      String encodedString = letterMap.get(ch);
      sb.append(encodedString != null ? encodedString : ch);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String original = scanner.nextLine().toLowerCase();
    System.out.println(new ANewAlphabet().translate(original));
  }
}
