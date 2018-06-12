function Person(first, last, age) {
    this.firstName = first;
    this.lastName = last;
    this.age = age;

    var getDetails=(Person) => {
        return Person.firstName+" "+Person.lastName+", "+Person.age
}}
var Benedikte = new Person("Benedikte", "Majbrink", 47);
var Bo = new Person("Bo", "Henriksen", 43);

console.log(getDetails(Benedikte))
console.log(getDetails(Bo))
