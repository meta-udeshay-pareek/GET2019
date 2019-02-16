function removeRepetedCharacter() {
   
    var string = document.getElementById("sringInput").value;
    var newString="";
    var resultStrings=string+"->";

    while(true){
        for(var i=0;i<string.length;i++){
            if(string.charAt(i)==string.charAt(i+1)){
                i++;
                newString+=string.substring(++i,string.length);
                break;
            }else{
                newString+=string.charAt(i);
            }
        }
        if(string==newString){
            break;
        }
        else{
            string=newString;
            resultStrings+=newString+"->";
            newString="";
        }
    }

    document.getElementById("outputString").innerHTML="Result String:"+resultStrings.substring(0,resultStrings.length-2);
    document.getElementById("sringInput").value="";

}