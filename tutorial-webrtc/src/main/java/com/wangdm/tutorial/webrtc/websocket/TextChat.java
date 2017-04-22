package com.wangdm.tutorial.webrtc.websocket;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.wangdm.tutorial.webrtc.message.TextMessage;

@ServerEndpoint("/textchat")
public class TextChat {
    
    private static final List<Session> clients = new LinkedList<Session>();  
    
    @OnOpen
    public void onOpen(Session session){
        clients.add(session);
        String id = session.getId();
        try {
            TextMessage message = new TextMessage("id","",id);
            session.getBasicRemote().sendText(message.encode());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("client connected");
    }

    @OnClose
    public void onClose(Session session){
        clients.remove(session);
        System.out.println("client closed");
    }
    
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("client error");
    }
    
    @OnMessage
    public void onMessage(String message, Session session) throws IOException{
        System.out.println("client send " + message);
        TextMessage msg = new TextMessage("msg",session.getId(),message);
        String str = msg.encode();
        for(Session client : clients){
            client.getBasicRemote().sendText(str);
        }
    }
}
