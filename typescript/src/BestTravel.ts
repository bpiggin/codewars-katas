export function chooseBestSum(
  t: number,
  k: number,
  ls: number[],
): number | null {
  const combinations: any[] = findCombinations(ls, k);
  const distances = combinations.map((arr: number[]) =>
    arr.reduce((a, b) => a + b, 0),
  );
  const filteredDistances = distances.filter(
    (distance) => distance <= t && distance > 0,
  );
  return filteredDistances.length > 0 ? Math.max(...filteredDistances) : null;
}

const findCombinations = (
  arr: number[],
  length: number,
  prevArr: number[] = [],
) => {
  if (prevArr.length === length) {
    return prevArr;
  }

  const combinations: any[] = [];
  for (let i = 0; i < arr.length; i++) {
    const newPrevArr = [...prevArr];
    newPrevArr.push(arr[i]);
    combinations.push(findCombinations(arr.slice(i + 1), length, newPrevArr));
  }
  const flattened = flatten(combinations);
  const ret: any[] = [];
  for (let i = 0; i < flattened.length; i += length) {
    ret.push(flattened.slice(i, i + length));
  }
  return ret;
};

const flatten = (arr: any[]): any[] => {
  const flat = [].concat(...arr);
  return flat.some(Array.isArray) ? flatten(flat) : flat;
};

console.log(
  chooseBestSum(163, 3, [50, 55, 56, 57, 58]) === 163 ? "Passed!" : "Failed :(",
);
console.log(chooseBestSum(163, 3, [50]) === null ? "Passed!" : "Failed :(");
console.log(
  chooseBestSum(230, 3, [91, 74, 73, 85, 73, 81, 87]) === 228
    ? "Passed!"
    : "Failed :(",
);
