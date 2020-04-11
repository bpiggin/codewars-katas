function spinWords(str) {
  var arr = str.split(" ");

  arr = arr.map((item) => reverseIfGreaterThan4(item));
  return arr.join(" ");
}

function reverseIfGreaterThan4(str) {
  return str.length > 4 ? str.split("").reverse().join("") : str;
}

console.log(spinWords("Welcome") == "emocleW");
