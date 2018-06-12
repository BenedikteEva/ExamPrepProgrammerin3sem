// declaring an array of names (strings) and writing them to console(not that we should the latter but needed to figure out 
// stuff about this new codeeditor)

var names =["Allan", "Hans", "Werner", "Bitten", "Gertrud", "Hassan", "Ib", "Bo", "Ida"];
for (var i=0; i< names.length; i++){
    console.log(names[i]);
}

// filter 

var equalsOrLessThanThree = names.filter(function(a1){
    return a1.length <= 3;
});
console.log(equalsOrLessThanThree);

// map and uppercased

var namesUpCased = names.map(function(el, i) {
    return { index: i, value: el.toUpperCase() };  });
    console.log(namesUpCased); 

//FIlter function with callback  

function callbackFilter(arr){
    var lengthLessOrEqualTo3=[];
    for(var i = 0; i < arr.length; i++) {
        if (arr[i].length<=3) lengthLessOrEqualTo3.push(arr[i]);
      }
   console.log(lengthLessOrEqualTo3);
}
function myFilter(array, callback){
return callback(array);
}

//myFilter(names,callbackFilter);
myFilter(names,callbackFilter);

//it only works with string funny enough when i wrtite it as below it returns 3,4,5 . 
var numbers="345";
myFilter(numbers,callbackFilter);
var a;

// myFilter excersice. 
function callbackMap(arr){
    var myMapReturn=[];
    for(var i = 0; i < arr.length; i++) {
        a=arr[i];
        myMapReturn.push(a.toUpperCase());
      }
 return myMapReturn;
 console.log(myMapReturn);
}

function myMap(array, callback){
    return callback(array);
    }

  console.log(myMap(names,callbackMap));


  