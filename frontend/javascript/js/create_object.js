/**
 * Created by bejond on 16-4-20.
 */
/**
 * 对象初始化器方式
 * @type {{name: string, age: number, email: string, say: Function, addAge: Function}}
 */
var marry = {
    name: "Marry",
    age: 23,
    email: "bejond@163.com",
    say: function() {
        document.writeln("Hi, my name is " + this.name); // 引用内部变量要加this
    },
    addAge: function() {
        return ++this.age;
    }
};

marry.say();
document.writeln("Next year, " + marry.name + " is " + marry.addAge() + " years old.");
document.writeln("<br />");
document.writeln("marry.age: " + marry.age);
document.writeln("<br />");

/**
 * 构造函数方式
 * @param name
 * @param age
 * @constructor
 */
function Sheep(name, age) {
    this.name = name;
    this.age = age;
    this.shout = function() {
        document.writeln(this.age + "岁小羊咩咩咩");
    };
}

var tom = new Sheep("Tom", 2);
tom.shout();