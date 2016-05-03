/**
 * Created by bejond on 5/3/16.
 */
function loadName() {
    var xmlHttp;
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    }
    else {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            document.getElementById("name").value = xmlHttp.responseText;
        }
    }

    xmlHttp.open("get", "getAjaxName?name=David", true);
    xmlHttp.send();
}

var xmlHttp;
if (window.XMLHttpRequest) {
    xmlHttp = new XMLHttpRequest();
}
else {
    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
}

function loadNameLikeForm(id) {
    
    alert("readyState: " + xmlHttp.readyState + ", status: " + xmlHttp.status);
    
    xmlHttp.onreadystatechange = function () {

        alert("readyState: " + xmlHttp.readyState + ", status: " + xmlHttp.status);

        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            document.getElementById(id).value = xmlHttp.responseText;
        }
    }

    xmlHttp.open("POST", "getAjaxName", true);

    xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xmlHttp.send("name=Bejond");
}

function loadXmlFile(id) {
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            var xmlDocument = xmlHttp.responseXML;
            txt = "";

            elements = xmlDocument.getElementsByTagName("author");

            for (i = 0; i < elements.length; i++) {
                txt += elements[i].firstChild.nodeValue + "<br/>";
                // txt += elements[i].childNodes[0].nodeValue + "<br/>";
            }

            document.getElementById(id).innerHTML = txt;
        }
    }

    xmlHttp.open("get", "xml/books.xml", true);
    xmlHttp.send();
}