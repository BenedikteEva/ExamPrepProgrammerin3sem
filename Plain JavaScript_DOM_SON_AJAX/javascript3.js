function Person(name, lastname, age){
this.name = name;
this.lastname = lastname;
this.age = age;
this.desc = "My name is " + this.name + " and my last name is " + this.lastname + " and i am " + this.age + " years old";
}

var Kasper = new Person("Kasper", "Vink", 27);
console.log(Kasper.desc);

//Opgaven er måske ikke helt forstået? 
/* 
Implement a reusable function using JavaScript closures that should encapsulate information about a person (name, and age) and returns an object with the following methods:
setAge
setName
getInfo (should return a string like Peter, 45) */
var person = (function (name,lastname,age) {
    var line = "My name is " +name + " and my last name is " + lastname + " and i am " + age + " years old";
    return function ()
})();
console.log(person("benedikte","majbrink",34))

var setName =(function())
var setAge = (function () {
    function setAge(age) {
        this.getAge = function () {
            return age;
        };
    }

    return setAge;
}());


var bo = new setAge(43);
delete bo.age;
console.log("Bo's age is " + bo.getAge());

function saygetInfo(name, age) {
    function setName= (function () {
        function setName(name {
            this.getName = function () {
                return name;
            };
        }
    
        return setAge;
    }());

    // helper nested function to use below
    function setAge = (function () {
        function setAge(age) {
            this.getAge = function () {
                return age;
            };
        }
    
        return setAge;
    }());
  
 
  
  }
  
  console.log(saygetInfo("benedikte",47))