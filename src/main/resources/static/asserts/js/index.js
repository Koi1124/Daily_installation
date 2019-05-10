var joinedList = new Array(9);
var totalPrice = 0;
var chooseType = 1;
var infoNumber = 0;
var pageNumber = 0;
var lastPage = 1;
var choosePage = 1;



function nextPage(no){
  if(no == choosePage)
  	return;
  if(no == -1 && choosePage == pageNumber)
  	return;
  
  var start = (choosePage-1)*6+1;
  var end = Math.min(choosePage*6, infoNumber);
  for(var i=start; i<=end; i++){ 	
  	  console.log("none: "+ i);
  	  var one = document.getElementById(chooseType + "-" + i);
  	  one.style.display = "none";  	
  }
  document.getElementById("page"+choosePage).className = "";
  if(no == -1){
    choosePage++;
  }
  else{
  	choosePage = no;
  }
  document.getElementById("page"+choosePage).className = "sel";
  var start2 = (choosePage-1)*6+1;
  var end2 = Math.min(choosePage*6, infoNumber);
  for(var i=start2; i<=end2; i++){ 	
  	  console.log("block: "+i);
  	  var one = document.getElementById(chooseType + "-" + i);
  	  one.style.display = "block";	
  }
}


function changePage(type){
  
  var info = document.getElementById("info");
  var page = document.getElementById("page");
  
  for(var i=7; i<=infoNumber; i++){
  	var one = document.getElementById(type + "-" + i);
  	one.style.display = "none"; 
  }

  info.innerHTML = infoNumber;
  pageNumber = Math.ceil(infoNumber/6);
  if(pageNumber == lastPage)
  	return;

  page.innerHTML = pageNumber;
  var pagebar = document.getElementById("pagebar");
  
  if(pageNumber > lastPage){
  	
    var nextpage = document.getElementById("nextpage");
  	for(var i= lastPage+1; i<=pageNumber; i++){
      var newpage =  document.createElement('span');
      newpage.innerHTML = i;
      newpage.id = "page"+i;
      //newpage.onclick = nextPage(i);
      pagebar.insertBefore(newpage, nextpage);
  	}
  }
  else if(pageNumber < lastPage){
  	for(var i= lastPage; i>pageNumber; i--){
  	  var delpage = document.getElementById("page"+i);
  	  pagebar.removeChild(delpage);
  	}
  }
 lastPage = pageNumber;
}



function ajax(type)
{
  var xmlhttp=new XMLHttpRequest();
  
  xmlhttp.onreadystatechange=function()
  {
    if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {   
      var text = xmlhttp.responseText;  //接收后台的参数    
      infoNumber = 21; //这里要改成实际数量;
      changePage(type);
    }
  }
  xmlhttp.open("POST","/switch",true);
  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
  xmlhttp.send("type=" + type);  // 将配件类型传给后台

}


function change(type){
  if(chooseType == type)
  	return;

  ajax(type);
  var old = document.getElementById("t" + chooseType);
  var t = document.getElementById("t" + type);
  chooseType = type;
  old.className = '';  
  t.className = 'choosed';
}


function funcDel(type){
  var no = joinedList[type];
  joinedList[type] = -1;
  var id = type+"-"+no;
  var addBtn = document.getElementById("add"+ id);
  addBtn.className = 'add';

  var show = document.getElementById("pic" + type);
  show.innerHTML = '';
  show.className = 'pic pic'+type ;

  var con = document.getElementById("con" + type);
  con.innerHTML = "请选择商品";
  con.className = 'zj-parts-con';

  var link = document.getElementById("link" + type);
  var total = document.getElementById("totalPrice");
  totalPrice -= parseInt(link.innerHTML.slice(1), 10);
  total.innerHTML = "¥ " + totalPrice;
  link.innerHTML = "添加";
  link.className = 'link-add';

  var del = document.getElementById("delete" + type);
  del.style.display = "none";
}


function add(type, no){
  if(joinedList[type] == no)
  	return;
  
  if(joinedList[type] != undefined && joinedList[type] != -1){
    	funcDel(1);
    }
  joinedList[type] = no;
  var id = type+"-"+no;
  var addBtn = document.getElementById("add"+ id);
  addBtn.className = 'joined';

  var img = document.getElementById("img" + id);
  var price = document.getElementById("price" + id);
  var show = document.getElementById("pic" + type);
  var img2 =  document.createElement('img');
  img2.src = img.src;
  show.appendChild(img2);
  show.className = 'pic img';

  var con = document.getElementById("con" + type);
  con.innerHTML = img.getAttribute('alt');
  con.className = 'zj-parts-con black';

  var link = document.getElementById("link" + type);
  link.innerHTML = price.innerHTML;
  link.className = 'link-add red';
  
  var del = document.getElementById("delete" + type);
  del.style.display = "block";

  var total = document.getElementById("totalPrice");
  totalPrice += parseInt(price.innerHTML.slice(1), 10);
  total.innerHTML = "¥ " + totalPrice;
}


function publish(){
  var name = document.getElementById("name").value;
  if(name == ''){
  	document.getElementById("name").setAttribute("placeholder","方案名称不能为空！");
  	return;
  }
  var instruct = document.getElementById("instruct").value;

  // 以下为ajax
  var xmlhttp=new XMLHttpRequest();
  
  xmlhttp.onreadystatechange=function()
  {
    if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {   
      var text = xmlhttp.responseText;  //接收后台的参数    
      document.getElementById("publish").innerHTML = "发表成功";

    }
  }
  var body = {name:name, instruct: instruct, s1:joinedList[1] }; //发送的数据
  xmlhttp.open("POST","/publish",true);
  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
  xmlhttp.send(body);  // 将配件类型传给后台
}


function clearAll(){
  for(var i=1; i<9; i++){
    if(joinedList[i] != undefined && joinedList[i] != -1){
    	funcDel(i);
    }
  }
}


window.onload = function () {  
  var t = document.getElementById("t1");
  t.className = 'choosed';
  infoNumber = 7; //这里要改成实际数量;
  changePage(1);
}