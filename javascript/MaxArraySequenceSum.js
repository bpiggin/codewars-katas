var maxSequence = function (arr) {
  let result = 0;
  let largestSum = 0;
  for (var i = 1; i < arr.length; i++) {
    largestSum = findLargestSubArraySum(i, arr);
    if (+largestSum > result) result = largestSum;
  }
  return result;
};

function findLargestSubArraySum(lengthOfSubArray, array) {
  let largestSum = 0;
  let result = 0;
  for (var i = 0; i + lengthOfSubArray < array.length; i++) {
    result = array.slice(i, i + lengthOfSubArray).reduce((a, b) => +a + +b, 0);
    if (+result > largestSum) largestSum = result;
  }
  return largestSum;
}
console.log(maxSequence([-2, 1, -3, 4, -1, 2, 1, -5, 4]));
