function digital_root(n) {
  let sum = n
    .toString()
    .split("")
    .map(Number)
    .reduce(function (a, b) {
      return a + b;
    }, 0);
  return sum > 9 ? digital_root(sum) : sum;
}
