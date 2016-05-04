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

