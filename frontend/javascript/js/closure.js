/**
 * Created by bejond on 16-4-19.
 */
var a = "Bejond";

function test1() {
    var b = 33;
    c = 44;
    document.writeln(a);
    document.writeln("<br />");
}

test1();
// alert(b); this is wrong
document.writeln(c); // that's ok
document.writeln("<br />");

function test2() {
    var d = "dd";
    function test3() { // this function is closure
        document.writeln(d);
        document.writeln("<br />");

        return d + "!";
    }

    return test3();
}

var result = test2();
document.writeln(result);
document.writeln("<br />");


var name = "The Window";
var object = {
    name: "My Object",
    getNameFunction: function() {
        return function() {
            return this.name;
        };
    },
    getValueFunction: function() {
        var name1 = "Hahaha";
        return function() {
            return name1;
        };
    }
};

document.writeln(object.name);
document.writeln("<br />");
document.writeln(object.getNameFunction());
document.writeln("<br />");
document.writeln(object.getNameFunction()());
document.writeln("<br />");
document.writeln(object.getValueFunction());
document.writeln("<br />");
document.writeln(object.getValueFunction()());
document.writeln("<br />");