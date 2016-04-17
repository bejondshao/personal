/**
 * Created by bejond on 4/17/16.
 */
var p = new Object();
p.anyAttribute = "Bejond"; // 动态添加属性, 碉堡了
document.writeln(p.anyAttribute);
p.name = "Obj1";
p.description = "Hi, this is a javascript object.";
p.func = say; // 动态添加方法, 碉堡了
p.func(p.description);

delete p.description; // 删除属性, 方法
alert(p.description);

function say(something) {
    document.writeln(something);
}

function person(name, age) { // 构造方法
    this.name = name;
    this.age = age;
}

var p1 = new person("David", 25);
document.writeln(p1.name);
document.writeln(p1.age);
