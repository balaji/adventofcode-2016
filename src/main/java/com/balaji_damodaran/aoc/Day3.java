package com.balaji_damodaran.aoc;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day3 {

  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(Day3.class.getResourceAsStream("/day3.txt"));
    Day3 day3 = new Day3();
    int index = 0;
    int[][] keys = new int[5000][3];
    while (scanner.hasNext()) {
      keys[index][0] = scanner.nextInt();
      keys[index][1] = scanner.nextInt();
      keys[index][2] = scanner.nextInt();
      index++;
    }

    int counter = 0;
    for (int j = 0; j < 3; j++) {
      for (int i = 0; i < keys.length - 2; i += 3) {
        if (day3.isATriangle(keys[i][j], keys[i + 1][j], keys[i + 2][j])) {
          counter++;
        }
      }
    }
    System.out.println(counter);
  }

  boolean isATriangle(int... inputs) {
    Arrays.sort(inputs);
    return (inputs[0] + inputs[1] > inputs[2]);
  }
}
