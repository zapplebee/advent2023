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
    String numbersInInput = input.replaceAll("one", "1").replaceAll("two", "2")
        .replaceAll("three", "3").replaceAll("four", "4").replaceAll("five", "5")
        .replaceAll("six", "6").replaceAll("seven", "7").replaceAll("eight", "8")
        .replaceAll("nine", "9").replaceAll("[^0-9]", "");
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
