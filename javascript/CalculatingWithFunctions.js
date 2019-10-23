function zero(str) { 
  if (typeof str === 'undefined') return 0;
  return evaluateOperation(0, str);
}
function one(str) { 
  if (typeof str === 'undefined') return 1;
  return evaluateOperation(1, str);
}
function two(str) { 
  if (typeof str === 'undefined') return 2;
  return evaluateOperation(2, str);
}
function three(str) { 
  if (typeof str === 'undefined') return 3;
  return evaluateOperation(3, str);
}
function four(str) { 
  if (typeof str === 'undefined') return 4;
  return evaluateOperation(4, str);
}
function five(str) { 
  if (typeof str === 'undefined') return 5;
  return evaluateOperation(5, str);
}
function six(str) { 
  if (typeof str === 'undefined') return 6;
  return evaluateOperation(6, str);
}
function seven(str) { 
  if (typeof str === 'undefined') return 7;
  return evaluateOperation(7, str);
}
function eight(str) { 
  if (typeof str === 'undefined') return 8;
  return evaluateOperation(8, str);
}
function nine(str) { 
  if (typeof str === 'undefined') return 9;
  return evaluateOperation(9, str);
}

function plus(num) {
  return "+" + num;
}
function minus(num) {
  return "-" + num;
}
function times(num) {
  return "*" + num;
}
function dividedBy(num) {
  return "/" + num;
}

function evaluateOperation(num, str) {
  if (str.startsWith("+")) return num + parseInt(str.replace("+", ""));
  else if (str.startsWith("-")) return num - parseInt(str.replace("-", ""));
  else if (str.startsWith("*")) return num * parseInt(str.replace("*", ""));
  else if (str.startsWith("/")) return Math.floor(num / parseInt(str.replace("/", "")));
}