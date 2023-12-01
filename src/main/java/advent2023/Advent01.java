package advent2023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Advent01 {

  public static Integer getPartOneValue(String input) {
    String numbersInInput = input.replaceAll("[^0-9]", "");
    String firstNumber = String.valueOf(numbersInInput.charAt(0));
    String secondNumber = String.valueOf(numbersInInput.charAt(numbersInInput.length() - 1));
    Integer number = Integer.valueOf(firstNumber + secondNumber);
    return number;
  }

  public static Integer getPartTwoValue(String input) {
    String numbersInInput = input.replaceAll("one", "one1one").replaceAll("two", "two2two")
        .replaceAll("three", "three3three").replaceAll("four", "four4four")
        .replaceAll("five", "five5five").replaceAll("six", "six6six")
        .replaceAll("seven", "seven7seven").replaceAll("eight", "eight8eight")
        .replaceAll("nine", "nine9nine").replaceAll("[^0-9]", "");
    String firstNumber = String.valueOf(numbersInInput.charAt(0));
    String secondNumber = String.valueOf(numbersInInput.charAt(numbersInInput.length() - 1));
    Integer number = Integer.valueOf(firstNumber + secondNumber);
    return number;
  }

  public static void main(String[] args) {
    BufferedReader reader;
    Integer partOneAccumulator = 0;
    Integer partTwoAccumulator = 0;

    try {
      reader = new BufferedReader(new FileReader("inputs/01.txt"));
      String line = reader.readLine();

      while (line != null) {
        partOneAccumulator += getPartOneValue(line);
        partTwoAccumulator += getPartTwoValue(line);
        line = reader.readLine();
      }

      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("part 1: " + partOneAccumulator);
    System.out.println("part 2: " + partTwoAccumulator);
  }
}
