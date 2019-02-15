String.prototype.repeatify = function(n) {
    strArray = [];
    for (var i = 0; i < n; i++) {
      strArray.push(this);
    }
  };

function repeatifyString() {
    var string=document.getElementById("rstringInput").value;
    var n=document.getElementById("rnumberInput").value;   
    string.repeatify(n);
    var str="";
    for(var ts=0;ts<strArray.length;ts++) {
 		str+=strArray[ts];
    }
	document.getElementById("repetedString").innerHTML="Result :"+str;
}
