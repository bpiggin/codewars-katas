"use strict";
var __spreadArrays = (this && this.__spreadArrays) || function () {
    for (var s = 0, i = 0, il = arguments.length; i < il; i++) s += arguments[i].length;
    for (var r = Array(s), k = 0, i = 0; i < il; i++)
        for (var a = arguments[i], j = 0, jl = a.length; j < jl; j++, k++)
            r[k] = a[j];
    return r;
};
exports.__esModule = true;
function chooseBestSum(t, k, ls) {
    var combinations = findCombinations(ls, k);
    console.log(JSON.stringify(combinations));
    var distances = combinations.map(function (arr) {
        return arr.reduce(function (a, b) { return a + b; }, 0);
    });
    console.log(distances);
    var filteredDistances = distances.filter(function (distance) { return distance <= t && distance > 0; });
    return filteredDistances.length > 0 ? Math.max.apply(Math, filteredDistances) : null;
}
exports.chooseBestSum = chooseBestSum;
var findCombinations = function (arr, length, prevArr) {
    if (prevArr === void 0) { prevArr = []; }
    if (prevArr.length === length) {
        return prevArr;
    }
    var combinations = [];
    for (var i = 0; i < arr.length; i++) {
        var newPrevArr = __spreadArrays(prevArr);
        newPrevArr.push(arr[i]);
        combinations.push(findCombinations(arr.slice(i + 1), length, newPrevArr));
    }
    var flattened = flatten(combinations);
    var ret = [];
    for (var i = 0; i < flattened.length; i += length) {
        ret.push(flattened.slice(i, i + length));
    }
    return ret;
};
var flatten = function (arr) {
    var flat = [].concat.apply([], arr);
    return flat.some(Array.isArray) ? flatten(flat) : flat;
};
console.log(chooseBestSum(163, 3, [50, 55, 56, 57, 58]) === 163 ? "Passed!" : "Failed :(");
console.log(chooseBestSum(163, 3, [50]) === null ? "Passed!" : "Failed :(");
console.log(chooseBestSum(230, 3, [91, 74, 73, 85, 73, 81, 87]) === 228
    ? "Passed!"
    : "Failed :(");
