const fs = require("fs");
const child_process = require("child_process");
const assert = require("assert");

const input = fs.readFileSync("inputs/01.txt", "utf-8");

let part1Acc = 0;
let part2Acc = 0;

for (const line of input.split("\n")) {
  const x = line.replaceAll(/[^0-9]/g, "");
  const first = x.at(0);
  const last = x.at(-1);
  const value = parseInt(`${first}${last}`, 10);
  part1Acc += value;
}

for (const line of input.split("\n")) {
  const x = line
    .replaceAll("one", "1")
    .replaceAll("two", "2")
    .replaceAll("three", "3")
    .replaceAll("four", "4")
    .replaceAll("five", "5")
    .replaceAll("six", "6")
    .replaceAll("seven", "7")
    .replaceAll("eight", "8")
    .replaceAll("nine", "9")
    .replaceAll(/[^0-9]/g, "");
  const first = x.at(0);
  const last = x.at(-1);
  const value = parseInt(`${first}${last}`, 10);
  part2Acc += value;
}

child_process.execSync("javac src/main/java/advent2023/Advent01.java");

const javaOut = child_process
  .execSync("java -cp src/main/java advent2023/Advent01")
  .toString("utf-8")
  .trim();

const formattedJsOut = `part 1: ${part1Acc}
part 2: ${part2Acc}`;

assert(
  javaOut === formattedJsOut,
  `❌ Java and JavaScript don't agree\n--------------------------------------\n\nJava:\n${javaOut}\n\nJavaScript:\n${formattedJsOut}`
);

console.log(
  `✅ Java and JavaScript agree\n--------------------------------------\n`
);
console.log(javaOut);
