/**
 * Created by bejond on 4/17/16.
 */
window.alert("Hi Window.");
var result = confirm("Press Me");
var value = prompt("Hello");
document.writeln(result);
document.writeln("<br />");
document.writeln(value);
document.writeln("<br />");

function dzt() {
    alert("吊炸天");
}
var timeOutValue = setTimeout("dzt()", 3000);
document.writeln(timeOutValue);
document.writeln("<br />");

var date = new Date();
function getDate() {
    date.setSeconds(date.getSeconds() + 1);

    document.getElementById("date").innerHTML = date;
}
window.setInterval("getDate()", 1000);

window.open("http://bejondshao.github.io");

window.onload = function () {
    alert("页面加载完成.");
}

window.onresize = function() {
    alert("窗体大小发生了变化");
}