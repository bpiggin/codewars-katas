var solution = function(firstArray, secondArray) {
  return firstArray
    .map((item, i) => Math.abs(item - secondArray[i]) ** 2 / firstArray.length)
    .reduce((a, b) => a + b, 0);
};

console.log(typeof null);
console.log(typeof new Date());
console.log(typeof []);
console.log(typeof (x => x * 2));
console.log(typeof 2);
console.log(typeof typeof 2);
