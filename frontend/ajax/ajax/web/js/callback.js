/**
 * Created by bejond on 5/3/16.
 */
var xmlHttp;
if (window.XMLHttpRequest) {
    xmlHttp = new XMLHttpRequest();
}
else {
    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
}

function updateTime(id, url) {
    loadText(url, function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            document.getElementById(id).innerHTML = xmlHttp.responseText;
        }
    });
}

function loadText(url, callbackFunction) {
    xmlHttp.onreadystatechange = callbackFunction;
    xmlHttp.open("GET", url, true);
    xmlHttp.send();
}

function loadInfo(name, age, url) {
    loadText(url, function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            var dataObj = eval("(" + xmlHttp.responseText + ")");
            document.getElementById(name).innerHTML = dataObj.name;
            document.getElementById(age).innerHTML = dataObj.age;
        }
    });
}

function loadInfo2(id, url) {
    loadText(url, function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            var dataObj = eval("(" + xmlHttp.responseText + ")");

            var studentTable = document.getElementById(id);
            var newTr; // 行
            var newTd0; // 列
            var newTd1; // 列
            var newTd2; // 列
            var newTd3; // 列
            var newTd4; // 列
            var student;

            for (var i = 0; i < dataObj.students.length; i++) {
                student = dataObj.students[i];

                newTr = studentTable.insertRow();
                newTd0 = newTr.insertCell();
                newTd1 = newTr.insertCell();
                newTd2 = newTr.insertCell();
                newTd3 = newTr.insertCell();
                newTd4 = newTr.insertCell();

                newTd0.innerHTML = student.name;
                newTd1.innerHTML = student.age;
                newTd2.innerHTML = student.score.chinese;
                newTd3.innerHTML = student.score.maths;
                newTd4.innerHTML = student.score.english;
            }
        }
    })
}

function checkUsername(id1, id2, url) {
    var username = document.getElementById(id1).value;
    url += "&username=" + username;

    loadText(url, function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            var dataObj = eval("(" + xmlHttp.responseText + ")");

            if (dataObj.exists) {
                document.getElementById(id2).innerHTML = "<image src='img/no.png'/>&nbsp;用户名已存在";
            }
            else {
                document.getElementById(id2).innerHTML = "<image src='img/ok.png'/>";
            }
        }
    })
}
