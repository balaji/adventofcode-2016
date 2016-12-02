package com.balaji_damodaran.aoc;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Day1Test {

  @Test
  public void shouldTest() {
    Day1 day1 = new Day1();
    assertEquals(2, day1.calculate(Arrays.asList("R2", "R2", "R2")));
    assertEquals(5, day1.calculate(Arrays.asList("R2", "L3")));
    assertEquals(12, day1.calculate(Arrays.asList("R5", "L5", "R5", "R3")));
    assertEquals(4, day1.calculate(Arrays.asList("R8", "R4", "R4", "R8")));
  }
}