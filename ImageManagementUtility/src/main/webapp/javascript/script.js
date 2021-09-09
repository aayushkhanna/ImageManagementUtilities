function getConfirmation(){
	 var val = confirm("Do you want to delete ?");
if(val==true)
return true;
else
return false;
}

function validate()
{
var size =  document.getElementById('ImageFile').files[0].size;
var filePath=document.getElementById('ImageFile').value;
size = size/1024;

var allowedExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;
              
if(size>1024 || (!allowedExtensions.exec(filePath))) {
	
alert("File too big or file type is not image");
return false;
	}
else
	{
		return true;
	}
}
	
