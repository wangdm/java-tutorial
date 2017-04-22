<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web Video Chat</title>
<style type="text/css">
.chat{
    width:800px;
    height:450px;
    border:1px solid #ddd;
    margin:50px auto;
    position:relative;
}

.remote{
    width:100%;
    height:100%;
    float:left;
}

.local{
    width:320px;
    height:180px;
    position:absolute;
    right:0px;
    bottom:0px;
    float:left;
}
</style>
</head>
<body>
    <div class="chat">
        <div class="remote">
        </div>
        <div class="local">
            <video id="localCamera" autoplay="autoplay" width="100%" height="100%"></video>
        </div>
        <button id="call">call</button>
    </div>

</body>
<script type="text/javascript">
var localStream;
var localVideo = document.getElementById("localCamera");
var remoteVideo = document.getElementById("remoteCamera");
var callBtn = document.getElementById("call");

callBtn.onclick = function(){
    connection.createOffer(function(offer){
        connection.setLocalDescription(offer);
        var message = {};
        message.id = self;
        message.type = "offer";
        message.offer = offer;
        socket.send(JSON.stringify(message));
    }, function(e){
        console.log(e);
    }); 
}

var configuration = {"iceServers":[{"url":"stun.xten.com"}]};
var connection = new RTCPeerConnection(null);

connection.onaddstream = function(e){
    console.log("onaddstream");
    //console.log(e);
    remoteVideo.src = window.URL.createObjectURL(e.stream);
}

connection.onremovestream = function(e){
    console.log("onremovestream");
    //console.log(e);
}

connection.onicecandidate = function(e){
    console.log("onicecandidate");
    //console.log(e);
}

connection.onsignalingstatchange = function(e){
    console.log("onsignalingstatchange");
    //console.log(e);
}

connection.oniceconnectionstatchange = function(e){
    console.log("oniceconnectionstatchange");
    //console.log(e);
}

var socket = new WebSocket("wss://192.168.2.251:8443/tutorial-webrtc/videochat");
var self = null;

socket.onopen = function(event){
    if(hasUserMedia){
        navigator.getUserMedia({video: true, audio: false},function(s) {
            localStream = s;
            localVideo.src = window.URL.createObjectURL(s);
            connection.addStream(localStream);
        }, function(e){
            
        });
    }
};

socket.onclose = function(event){
    console.log(event);
}

socket.onerror = function(event){
    console.log(event);
}

socket.onmessage = function(event){
    var message = JSON.parse(event.data);
    switch(message.type){
    case "id":
        self = message.message;
        break;
    case "offer":
        handleOffer(message.offer);
        break;
    case "answer":
        handleAnswer(message.answer);
        break;
    case "candidate":
        handleCandidate(message.candidate);
        break;
    case "leave":
        break;
    }
};

function hasUserMedia(){
    navigator.getUserMedia = navigator.getUserMedia ||
                             navigator.webkitGetUserMedia ||
                             navigator.mozGetUserMedia ||
                             navigator.msGetUserMedia; 
    return navigator.getUserMedia;
}

function handleOffer(offer){
    connection.setRemoteDescription(new RTCSessionDescription(offer));
    connection.createAnswer(function(answer){
        connection.setLocalDescription(answer);
        var message = {};
        message.id = self;
        message.type = "answer";
        message.answer = answer;
        socket.send(JSON.stringify(message));
    },function(error){
        console.log(error);
    });
}

function handleAnswer(answer){
    connection.setRemoteDescription(new RTCSessionDescription(answer));
}

function handleCandidate(candidate){
    connection.addIceCandidate(new RTCIceCandidate(candidate)); 
}

</script>
</html>