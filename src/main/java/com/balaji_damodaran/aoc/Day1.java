package com.balaji_damodaran.aoc;

import java.util.List;

import static java.lang.Math.abs;

public class Day1 {

  enum Directions {
    N, E, W, S;
    private Directions left;
    private Directions right;

    static {
      N.setNeighbors(W, E);
      S.setNeighbors(E, W);
      W.setNeighbors(S, N);
      E.setNeighbors(N, S);
    }

    void setNeighbors(Directions d1, Directions d2) {
      this.left = d1;
      this.right = d2;
    }
  }

  class Point {
    private int y, x;
    private int visited[][];
    final static int SIZE = 1000;
    final static int MID = SIZE / 2;
    int destination = -1;

    Point(int x, int y) {
      this.y = MID + x;
      this.x = MID + y;
      this.visited = new int[SIZE][SIZE];
    }

    private void move(int xDelta, int yDelta) {
      int bx = x;
      int by = y;
      int countY = abs(yDelta);

      while(countY >= 0) {
        int countX = abs(xDelta);
        while (countX >= 0) {
          if(visited[by][bx] == 1 && (bx != x || by != y)) {
            destination = blocks(bx, by);
          }
          visited[by][bx] = 1;
          if (countX > 0) bx += (xDelta < 0) ? -1 : 1;
          countX--;
        }
        if (countY > 0) by += (yDelta < 0) ? -1 : 1;
        countY--;
      }

      y = y + yDelta;
      x = x + xDelta;
    }

    boolean hasDestination() {
      return destination != -1;
    }

    int blocks(int x, int y) {
      return abs(y - MID) + abs(x - MID);
    }
  }

  private void moveLocation(Directions directions, Point point, int steps) {
    switch (directions) {
      case E:
        point.move(steps, 0);
        break;
      case W:
        point.move(-steps, 0);
        break;
      case N:
        point.move(0, steps);
        break;
      case S:
        point.move(0, -steps);
        break;
    }
  }

  int calculate(List<String> instructions) {
    Point point = new Point(0, 0);
    Directions direction = Directions.N;
    for (String instruction : instructions) {
      instruction = instruction.trim();
      direction = (instruction.charAt(0) == 'L') ? direction.left : direction.right;
      moveLocation(direction, point, Integer.parseInt(instruction.substring(1)));
      if (point.hasDestination()) {
        return point.destination;
      }
    }
    return point.blocks(point.x, point.y);
  }
}
