function persistence(num) {
  let count = 0;

  while (num > 9) {
    num = calculateProduct(num);
    count++;
  }
  return count;
}

function calculateProduct(num) {
  num = "" + num;
  var digits = num.split('').map(Number);
  return digits.reduce(function(result, currentValue) {
    return result *= currentValue;
  })
}

console.log(persistence(39));