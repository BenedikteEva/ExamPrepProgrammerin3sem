var numbers = [1, 3, 5, 10, 11];





    function cbAll(number,index,array){
    while(index < arr.length-1){
        return number+arr[index+1];
    }
    }

function myMap(array,cb,index){
    var getNewArray = [];

    for(var i=0; i<arr.length; i++){
        let val = cb(arrray[i],i,array);
        getNewArray.push(val);
    }
   
    return getNewArray;
   
}
console.log(getNewArray);