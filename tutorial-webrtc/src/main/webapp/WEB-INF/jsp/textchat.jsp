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
.left .context{
    width:100%;
    height:360px;
}
.left .input{
    width:100%;
    height:40px;
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
            <div class="context"></div>
            <div class="input">
                <input type="text" id="msgInput"/>
                <button id="sendBtn">发送</button>
            </div>
        </div>
        <div class="userlist"></div>
    </div>
</body>
<script type="text/javascript">
    var socket = new WebSocket("ws://echo.websocket.org/");
    
    socket.onopen = function(event){
        console.log(event);
    };
    
    socket.onmessage = function(event){
        console.log(event);
    };
    
    socket.onclose = function(event){
        console.log(event);
    }
    
    socket.onerror = function(event){
        console.log(event);
    }
    
    var input = document.getElementById("msgInput");
    var sender = document.getElementById("sendBtn");
    
    sender.onclick = function(event){
        var message = input.value;
        socket.send(message);
    };

</script>
</html>