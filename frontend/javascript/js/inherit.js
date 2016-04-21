/**
 * Created by bejond on 16-4-20.
 */
function Animal(name) {
    this.name = name;
    this.shout = function() {
        document.write("叫");
    }
}

function Dog(name) {
    Animal.apply(this, [name]);
}

var jack = new Dog("Jack"); // jack is Dog
document.write(jack.name);
document.writeln("<br />");
jack.shout();
document.writeln("<br />");

function Cat(name) {
    Animal.apply(this, [name]);
}

Cat.prototype = new Animal();

var mimi = new Cat("mimi"); // mimi is Animal
mimi.shout();
document.writeln("<br />");

function Car() {
    this.drive = function() {
        document.write("Car, Driving");
    }
}

function Benz() {
    this.drive = function() {
        document.write("Benz, Driving");
    }
}
Benz.prototype = new Car();

function BMW() {
    this.drive = function() {
        document.write("BMW, Driving");
    }
}
BMW.prototype = new Car();

function drive(car) {
    if (car instanceof Car) {
        car.drive();
    }
    else {
        document.write("Hello");
    }

    document.writeln("<br />");
}

var benz = new Benz();
var bmw = new BMW();
drive(benz);
drive(bmw);