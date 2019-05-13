var joinedList = new Array(8);
var list =[0,50, 96, 89, 45, 45, 34, 45];
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
  
  //console.log("nextpage: "+no);
  var start = (choosePage-1)*6+1;
  var end = Math.min(choosePage*6, infoNumber);
  for(var i=start; i<=end; i++){ 	
  	  //console.log("none: "+ i);
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
  	  //console.log("block: "+i);
  	  var one = document.getElementById(chooseType + "-" + i);
  	  one.style.display = "block";	
  }
}


function addclick (no){
  //console.log("addclick: "+no);
  var mypage = document.getElementById("page"+no);
  mypage.onclick =  function(){ nextPage(no); }
}


function changePage(type){
  var info = document.getElementById("info");
  var page = document.getElementById("page");
  
  var start = (choosePage-1)*6+1;
  var end = Math.min(choosePage*6, infoNumber);
  for(var i=start; i<=end; i++){  
      //console.log("none: "+ i);
      var one = document.getElementById(chooseType + "-" + i);
      one.style.display = "none";   
  }
  
  chooseType = type;
  for(var i=1; i<=6; i++){    
      //console.log("block: "+i);
      var one = document.getElementById(type + "-" + i);
      one.style.display = "block";  
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
     
      pagebar.insertBefore(newpage, nextpage);
      addclick(i);
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
      console.log(text);
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
  
  var old = document.getElementById("t" + chooseType);
  var t = document.getElementById("t" + type);
  old.className = '';  
  t.className = 'choosed';

  infoNumber = list[type]; //这里要改成实际数量;
  changePage(type);
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
  if(document.getElementById("name").value == ''){
  	document.getElementById("name").setAttribute("placeholder","方案名称不能为空！");
  	return;
  }
  //var instruct = document.getElementById("instruct").value;

  // 以下为ajax
  //var xmlhttp=new XMLHttpRequest();
  
  //xmlhttp.onreadystatechange=function()
  //{
  //  if (xmlhttp.readyState==4 && xmlhttp.status==200)
  //  {
  //    var text = xmlhttp.responseText;  //接收后台的参数
  //    document.getElementById("publish").innerHTML = "发表成功";

  //  }
  //}
  document.getElementById("cpuName").value = document.getElementById("con1").innerText;
  document.getElementById("cpuImg").value = document.getElementById("pic1").firstChild.src;
  document.getElementById("motherBoardName").value = document.getElementById("con2").innerText;
  document.getElementById("motherBoardImg").value = document.getElementById("pic2").firstChild.src;
  document.getElementById("memoryName").value = document.getElementById("con3").innerText;
  document.getElementById("memoryImg").value = document.getElementById("pic3").firstChild.src;
  document.getElementById("hddName").value = document.getElementById("con4").innerText;
  document.getElementById("hddImg").value = document.getElementById("pic4").firstChild.src;
  document.getElementById("ssdName").value = document.getElementById("con5").innerText;
  document.getElementById("ssdImg").value = document.getElementById("pic5").firstChild.src;
  document.getElementById("gpuName").value = document.getElementById("con6").innerText;
  document.getElementById("gpuImg").value = document.getElementById("pic6").firstChild.src;
  document.getElementById("powerSupplyName").value = document.getElementById("con7").innerText;
  document.getElementById("powerSupplyImg").value = document.getElementById("pic7").firstChild.src;
  document.getElementById("instruct-form").value = document.getElementById("instruct").innerText;
  document.forms["formHome"].submit();
  //var body = {'name':name, 'instruct': instruct, 's1':joinedList }; //发送的数据
  //console.log(body);
  //xmlhttp.open("POST","/publish",true);
  //xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
  //xmlhttp.send(body);  // 将配件类型传给后台
}


function clearAll(){
  for(var i=1; i<8; i++){
    if(joinedList[i] != undefined && joinedList[i] != -1){
    	funcDel(i);
    }
  }
}


window.onload = function () {  
  var t = document.getElementById("t1");
  t.className = 'choosed';
  infoNumber = 50; //这里要改成实际数量;
  changePage(1);
}