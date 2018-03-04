package com.dreamsmadevisible.kattis.quadrantselection;

import java.util.Scanner;

public class QuadrantSelection {
  public QuadrantSelection() { }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt();
    int y = scanner.nextInt();

    if (x > 0) {
      System.out.println(y > 0 ? 1 : 4);
    } else {
      System.out.println(y > 0 ? 2 : 3);
    }
  }
}
