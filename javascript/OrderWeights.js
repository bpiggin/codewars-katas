function orderWeight(strng) {
  //Deal with empty string
  strng = strng.trim();
  if (strng === "") return "";

  let arr = strng.split(/\s+/);
  arr.sort(function(a, b) {
    aSum = sumDigits(a);
    bSum = sumDigits(b);
  
    if (aSum < bSum) {
      return -1;
    }
    if (aSum > bSum) {
      return 1;
    }
    if (a < b) {
      return -1;
    }
    if (a > b) {
      return 1;
    }
    return 0;
  });
  return arr.join(' ');
}

function sumDigits(str) {
  arr = str.split('');
  arr.map(Number);
  return arr.reduce((sum, item) => +sum + +item, 0);
}

console.log(orderWeight("103 123 4444 99 2000"));