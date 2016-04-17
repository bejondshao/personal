/**
 * Created by bejond on 4/17/16.
 */
var arr = new Array();
var arr2 = new Array(4);

for (var i =0; i < arr2.length; i++) {
    arr[i] = "Name" + i;
    arr2[i] = i;
}

document.writeln(arr[2]);
document.writeln("<br />");
document.writeln(arr2[3]);
document.writeln("<br />");

for (var o in arr) {
    document.writeln(o);
    document.writeln(arr[o]);
}
document.writeln("<br />");

arr[1] = "Snack";
arr.sort();

for (var o in arr) {
    document.writeln(arr[o]);
}
document.writeln("<br />");

document.writeln(arr); // 对象默认打印效果
document.writeln("<br />");
document.writeln(arr.join(", ")); // 使用join后组合成一个字符串输出, 但是arr依然是数组
document.writeln("<br />");
document.writeln(arr.join("_ "));
document.writeln("<br />");
document.writeln(arr[2]);
document.writeln("<br />");

var arr3 = arr.concat(arr2);
document.writeln(arr3);
document.writeln("<br />");

var arr4 = arr.reverse();
document.writeln(arr4);