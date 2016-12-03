package com.balaji_damodaran.aoc;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class Day3Test {
  @Test
  public void shouldTest() {
    Day3 day3 = new Day3();
    assertFalse(day3.isATriangle(5, 10, 25));
  }
}