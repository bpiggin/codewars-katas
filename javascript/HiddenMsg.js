var recoverSecret = function (triplets) {
  let msg = "";
  let letters = new Set([].concat(...triplets));
  while (letters.size > 0) {
    for (let letter of letters) {
      let alwaysFirst = true;
      for (let i = 0; i < triplets.length; i++) {
        let triplet = triplets[i];
        let index = triplet.indexOf(letter);
        if (index > 0) {
          alwaysFirst = false;
          break;
        }
      }
      if (alwaysFirst) {
        letters.delete(letter);
        triplets = removeLetter(triplets, letter);
        msg += letter;
      }
    }
  }
  return msg;
};

removeLetter = (arr, letter) => {
  let ret = [];
  for (let i = 0; i < arr.length; i++) {
    let subArr = arr[i];
    let index = subArr.indexOf(letter);
    if (index !== -1) {
      subArr.splice(index, 1);
    }
    ret.push(subArr);
  }
  return ret;
};

triplets1 = [
  ["t", "u", "p"],
  ["w", "h", "i"],
  ["t", "s", "u"],
  ["a", "t", "s"],
  ["h", "a", "p"],
  ["t", "i", "s"],
  ["w", "h", "s"],
];
console.log(recoverSecret(triplets1));
