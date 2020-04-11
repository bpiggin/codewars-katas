export function chooseBestSum(
  t: number,
  k: number,
  ls: number[],
): number | null {
  // your code
}

console.log(
  chooseBestSum(163, 3, [50, 55, 56, 57, 58]) === 163 ? "Passed!" : "Failed :(",
);
console.log(chooseBestSum(163, 3, [50]) === null ? "Passed!" : "Failed :(");
console.log(
  chooseBestSum(230, 3, [91, 74, 73, 85, 73, 81, 87]) === 228
    ? "Passed!"
    : "Failed :(",
);
