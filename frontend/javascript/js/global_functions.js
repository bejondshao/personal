/**
 * Created by bejond on 4/17/16.
 */
var url = "http://bejondshao.github.io/Home page";
document.writeln(encodeURI(url));
document.writeln("<br />");
document.writeln(decodeURI(url));
document.writeln("<br />");
document.writeln(escape(url));
document.writeln("<br />");

var command = "document.writeln(\"Hi Boy\"); document.writeln(\"\<br \/\> \")";
eval(command);

document.write(isNaN(1.23));
document.writeln("<br />");
document.write(isNaN("1.23"));
document.writeln("<br />");
document.write(isNaN("1.2sde3"));
document.writeln("<br />");

var test = new String("1e3");
document.writeln(Number(test));
document.writeln("<br />");
document.writeln(parseInt(test));
document.writeln("<br />");
document.writeln(parseInt(Number(test)));
document.writeln("<br />");