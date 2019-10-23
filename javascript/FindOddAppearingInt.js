function findOdd(A) {
  //Sort numbers in ascending order.
  A.sort(function(a, b){return a-b});
  var count = 0;
  for (var i=0; i<A.length; i++) {
    //Keep track of how many of each element.
    if (A[i] == A[i + 1]) {
      count++;
    }
    //Found the int that appears an even number of times.
    else if (count % 2 == 0) {
      return A[i];
    }
    //Reset the count.
    else count = 0;
  }
}