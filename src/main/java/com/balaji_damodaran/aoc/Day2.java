package com.balaji_damodaran.aoc;

public class Day2 {
  private int cPos[] = {2, 0};
  private char[][] keypad = {
      {'0', '0', 'D', '0', '0'},
      {'0', 'A', 'B', 'C', '0'},
      {'5', '6', '7', '8', '9'},
      {'0', '2', '3', '4', '0'},
      {'0', '0', '1', '0', '0'}
  };

  char getDigit(String instructions) {
    char[] inst = instructions.toCharArray();
    for (char c : inst) {
      switch (c) {
        case 'R':
          if (cPos[1] < 4 && validKey(new int[]{cPos[1] + 1, cPos[0]})) cPos[1] += 1;
          break;
        case 'L':
          if (cPos[1] > 0 && validKey(new int[]{cPos[1] - 1, cPos[0]})) cPos[1] -= 1;
          break;
        case 'U':
          if (cPos[0] < 4 && validKey(new int[]{cPos[1], cPos[0] + 1})) cPos[0] += 1;
          break;
        case 'D':
          if (cPos[0] > 0 && validKey(new int[]{cPos[1], cPos[0] - 1})) cPos[0] -= 1;
          break;
      }
    }
    return keypad[cPos[0]][cPos[1]];
  }

  private boolean validKey(int[] combo) {
    return (keypad[combo[1]][combo[0]] != '0');
  }
}
