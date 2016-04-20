/**
 * Created by bejond on 4/19/16.
 */
function say(name, nickname) {
    document.writeln(name + "'s nickname is " + nickname);
    document.writeln("<br />");
}
say("高德龙", "小六子");

var sayFunction = new Function("name", "age", "document.writeln(name + \"'s age is \" + age); " +
"document.writeln(\"<br />\");");

sayFunction("Jojo", 14);

document.writeln("方法参数的个数: " + sayFunction.length);
document.writeln("<br />");
document.writeln(sayFunction.toString());
document.writeln("<br />");