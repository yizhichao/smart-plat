package com.allcam.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocket
{
    public static Map<String,Session> sessionPool = new HashMap<String,Session>();
    
    @OnMessage
    public void onMessage(String message, Session session)
        throws IOException, InterruptedException
    {
        session.getBasicRemote().sendText(message);
    }
    
    @OnOpen
    public void onOpen(Session session) throws IOException
    {
        sessionPool.put(session.getId(),session);
        session.getBasicRemote().sendText(session.getId());
    }
    
    @OnClose
    public void onClose(Session session)
    {
        sessionPool.remove(session.getId());
    }
}