/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    var i = n;
    return function() {
        i+=1;
        return i-1;
    };
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */