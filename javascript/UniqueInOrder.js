var uniqueInOrder = function (iterable) {
  let arr = iterable;

  //Make the object an array if necessary.
  if (!Array.isArray(iterable)) {
    arr = iterable.split("");
  }

  //Perform filtering.
  return arr.filter(function (item, index, self) {
    return item != self[index + 1];
  });
};
