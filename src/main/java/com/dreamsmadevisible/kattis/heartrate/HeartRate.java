package com.dreamsmadevisible.kattis.heartrate;

import java.util.Scanner;

/**
 * Problem definition: https://open.kattis.com/problems/heartrate
 */
public class HeartRate {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numCases = scanner.nextInt();

    for (int i = 0; i < numCases; i++) {
      int beats = scanner.nextInt();
      double time = scanner.nextDouble();

      double actualBeats = 60 * beats / time;
      double delta = 60 / time;
      double minBeats = actualBeats - delta;
      double maxBeats = actualBeats + delta;

      System.out.printf("%.4f %.4f %.4f\n", minBeats, actualBeats, maxBeats);
      // System.out.println(minBeats + " " + actualBeats + " " + maxBeats);
    }
  }
}
