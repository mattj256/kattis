package com.dreamsmadevisible.kattis.temperature;

import java.util.Scanner;

/**
 * Problem definition: https://open.kattis.com/problems/temperature
 */
public class Temperature {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    if (y == 1) {
      System.out.println(x == 0 ? "ALL GOOD" : "IMPOSSIBLE");
    } else {
      System.out.println(x / (1.0 - y));
    }
  }
}
