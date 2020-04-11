decodeMorse = function (morseCode) {
  let words = morseCode.trim().split("   "); //3 spaces separate words.
  var wordsDecoded = [];

  for (var i = 0; i < words.length; i++) {
    wordsDecoded[i] = decodeWord(words[i]);
  }

  return wordsDecoded.join(" ");
};

function decodeWord(morse) {
  let arr = morse.split(" "); //one space separates chars.
  var wordArr = [];

  for (var i = 0; i < arr.length; i++) {
    wordArr[i] = MORSE_CODE[arr[i]];
  }

  return wordArr.join("");
}

console.log(decodeMorse(".... . -.--   .--- ..- -.. ."));
