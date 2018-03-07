package com.dreamsmadevisible.kattis.lineup;

import java.util.Scanner;

enum Order {
  UNKNOWN, INCREASING, DECREASING, NEITHER;
}

/**
 * Problem definition: https://open.kattis.com/problems/lineup
 */
public class Lineup {

  private static Order getOrder(String personA, String personB) {
    return personA.compareTo(personB) < 0 ? Order.INCREASING : Order.DECREASING;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Order order = Order.UNKNOWN;
    int num = scanner.nextInt();
    scanner.nextLine();
    String personA = null;
    String personB = scanner.nextLine();

    for (int i = 0; i < num - 1; i++) {
      personA = personB;
      personB = scanner.nextLine();
      Order thisOrder = getOrder(personA, personB);
      if (order == Order.UNKNOWN) {
        order = thisOrder;
      } else if (order == thisOrder) {
        // do nothing
      } else {
        order = Order.NEITHER;
        break;
      }
    }

    System.out.println(order);
  }
}
