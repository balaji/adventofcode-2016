package com.balaji_damodaran.aoc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day2Test {

  @Test
  public void shouldTest() {
    Day2 day2 = new Day2();
    assertEquals('5', day2.getDigit("ULL"));
    assertEquals('D', day2.getDigit("RRDDD"));
    assertEquals('B', day2.getDigit("LURDL"));
    assertEquals('3', day2.getDigit("UUUUD"));
  }
}