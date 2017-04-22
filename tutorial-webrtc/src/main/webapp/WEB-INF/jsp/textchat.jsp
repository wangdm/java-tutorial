<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web Text Chat</title>
<style type="text/css">
.chat{
    width:700px;
    height:400px;
    border:1px solid #ddd;
    margin:50px auto;
}
.left{
    width:500px;   
    height:100%;
    float:left;
}
.left .content{
    width:100%;
    height:360px;
    float:left;
}
.left .content ul{
    list-style-type: none;
    margin:0px;
    padding:0px;
    float:left;
    width:100%;
    max-height:360px;
    overflow:auto;
}
.left .content ul li{
    float:left;
    width:100%;
}
.left .content ul li span{
    border:1px solid #dddddd;
    border-radius:5px;
    margin:2px;
    padding:5px;
    float:left;
    background-color:rgb(205,215,206);
}
.left .content ul li span.self{
    float:right;
    background-color:rgb(120,205,248);
}
.left .input{
    width:100%;
    height:40px;
    float:left;
}
.left .input input{
    margin:2px 2px;
    line-height:30px;
    font-size:20px;
}
.userlist{
    width:200px;
    height:100%;
    float:left;
}
</style>
</head>
<body>
    <div class="chat">
        <div class="left">
            <div class="content">
                <ul id="msgContent">
                </ul>
            </div>
            <div class="input">
                <input type="text" id="msgInput"/>
                <button id="sendBtn">发送</button>
            </div>
        </div>
        <div class="userlist"></div>
    </div>
</body>
<script type="text/javascript">
    var socket = new WebSocket("ws://localhost:8080/tutorial-webrtc/textchat");
    var self = null;
    
    socket.onopen = function(event){
        console.log(event);
    };
    
    socket.onmessage = function(event){
        console.log(event);
        var message = JSON.parse(event.data);
        switch(message.type){
        case "id":
            self = message.message;
            break;
        case "list":
            break;
        case "msg":
            if(message.sender!=self)
                displayMsg(false, message.message);
            break;
        }
    };
    
    socket.onclose = function(event){
        console.log(event);
    }
    
    socket.onerror = function(event){
        console.log(event);
    }
    
    var input = document.getElementById("msgInput");
    var sender = document.getElementById("sendBtn");
    var content = document.getElementById("msgContent");
    
    sender.onclick = function(event){
        var message = input.value;
        socket.send(message);
        displayMsg(true, message);
    };
    
    function displayMsg(self, message){
        var li = document.createElement("li");
        var span = document.createElement("span");
        var text = document.createTextNode(message);
        if(self){
            span.setAttribute("class", "self");
        }
        span.appendChild(text);
        li.appendChild(span);
        content.appendChild(li);
    }

</script>
</html>