/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {
    var a1 = val;
    return {
        toBe:function(a2){
            if(a1 === a2){
                return true
            }else{
                throw new Error("Not Equal")
            }
        },
        notToBe:function(a2){
            if(a1 !== a2){
                return true
            }else{
                throw new Error("Equal")
            }
        }
    };
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */