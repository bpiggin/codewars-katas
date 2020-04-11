function squareDigits(num) {
  let arr = Array.from(String(num), Number);
  let result = arr.map((x) => x ** 2);
  return Number(result.join(""));
}

console.log(squareDigits(9119) == 811181);
