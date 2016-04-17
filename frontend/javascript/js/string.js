/**
 * Created by bejond on 4/17/16.
 */
var str = "这是个字符串.";
document.writeln("str = " + str);
document.writeln("<br />");
var str2 = new String("Another String");
document.writeln("str2 = " + str2);
document.writeln("<br />");

document.writeln("str.length: " + str.length);
document.writeln("<br />");

document.writeln("str2 index of \"t\": " + str2.indexOf("t"));
document.writeln("<br />");
document.writeln("str2 last index of \"t\": " + str2.lastIndexOf("t"));
document.writeln("<br />");

document.writeln("str2 replace \"t\" with \"r\": " + str2.replace("t", "r"));
document.writeln("<br />");