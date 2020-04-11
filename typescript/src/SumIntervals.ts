function sumIntervals(intervals: [number, number][]) {
  let sum = 0;
  let computed = [];
  for (let i = 0; i < intervals.length; i++) {
    let interval = intervals[i];
    for (let j = interval[0]; j < interval[1]; j++) {
      computed[j] = 1;
    }
  }
  return computed.reduce((a, b) => {
    return b ? a + b : a;
  }, 0);
}
