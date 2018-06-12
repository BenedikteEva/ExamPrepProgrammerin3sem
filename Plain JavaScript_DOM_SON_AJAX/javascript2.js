//-------------------------------

var votes = [ "Clinton","Trump","Clinton","Clinton","Trump","Trump","Trump","None"];

/*function voteObject(Clinton, Trump, None){
this.Clinton = Clinton;
this.Trump = Trump;
this.None = None;
} */
/* var totalVotes = new voteObject(0,0,0);
var allVotes = votes.reduce(function(Acumulator, currValue, index, array) {
if (currValue === "Clinton") {
    //++totalVotes.Clinton;
} else if(currValue === "Trump"){
    //++totalVotes.Trump;
} else {
    //++totalVotes.None;
} 
},{totalVotes}); */


/* console.log(allVotes); */

var initialValue = {};
var reducer = function(tally, vote){
    if (!tally[vote]) {
        tally[vote] = 1;
    } else {
        tally[vote] = tally[vote] + 1;
    }
    return tally;
}

var result = votes.reduce(reducer, initialValue);

console.log(result);