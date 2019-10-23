function solution(str) {
  let splitString = str.split("");
  let reverseArray = splitString.reverse();
  return reverseArray.join("");
}

console.log(solution('world') == 'dlrow');