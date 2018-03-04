package com.dreamsmadevisible.kattis.spavanac;

import java.util.Scanner;

/**
 * Problem definition: https://open.kattis.com/problems/spavanac
 */
public class Spavanac {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int hour = scanner.nextInt();
    int minute = scanner.nextInt();

    minute -= 45;
    if (minute < 0) {
      minute += 60;
      hour--;
    }
    if (hour < 0) {
      hour += 24;
    }

    System.out.println(hour + " " + minute);
  }
}
