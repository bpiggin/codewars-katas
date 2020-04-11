function biggestNum(a, b) {
  //Get rid of excess minus signs and leading zeros.
  a = resolveMinusSignsAndRemoveLeadingZeros(a);
  b = resolveMinusSignsAndRemoveLeadingZeros(b).replace(/^0+(?=\d)/, "");

  return greaterThan(a, b);
}

function resolveMinusSignsAndRemoveLeadingZeros(str) {
  if ((str.split("-").length - 1) % 2 == 0) {
    str = str.replace(/-/g, "").replace(/^0+(?=\d)/, "");
  } else {
    str = str.replace(/-/g, "").replace(/^0+(?=\d)/, "");
    str = "-" + str;
  }
  return str;
}

function greaterThan(a, b) {
  if (+a < Number.MAX_SAFE_INTEGER && +b < Number.MAX_SAFE_INTEGER) {
    return +a > b ? a : b;
  }

  //Need to deal with 4 boring cases here.
  //1 - a < 0, b > 0
  if (a.startsWith("-") && !b.startsWith("-")) return b;
  //2 - a > 0, b < 0
  if (!a.startsWith("-") && b.startsWith("-")) return a;

  let aArray = a.split("");
  let bArray = b.split("");

  //3 - a < 0, b < 0
  let bothNegative = false;
  if (a.startsWith("-") && b.startsWith("-")) {
    if (aArray.length < bArray.length) return a;
    if (aArray.length > bArray.length) return b;
    bothNegative = true;
  }

  //4 - a > 0, b > 0
  if (!a.startsWith("-") && !b.startsWith("-")) {
    if (aArray.length < bArray.length) return b;
    if (aArray.length > bArray.length) return a;
  }

  //They are the same length.
  var arrayLength = aArray.length;
  for (var i = 0; i < arrayLength; i++) {
    if (aArray[i] < bArray[i] && !bothNegative) return b;
    if (aArray[i] < bArray[i] && bothNegative) return a;
  }
  return bothNegative ? b : a;
}

console.log(biggestNum("214", "--507"));
