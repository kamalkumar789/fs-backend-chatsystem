package com.chatsystem.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Service
@Setter
@Getter
public class SocketEvents {
    

    @Autowired
    private SocketIOServer socketIOServer;

    private Map<String, SocketIOClient> connections = new HashMap<>();

    @PostConstruct
    public void intilize(){

        socketIOServer.start();

        socketIOServer.addConnectListener(new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient socket) {

                String userId = socket.getHandshakeData().getUrlParams().get("userId").get(0);
                if(connections.containsKey(userId)){
                    return;
                }
                System.out.println("Socket is connected " + userId);
                connections.put(userId, socket);
            }
        });
        
        socketIOServer.addDisconnectListener(new DisconnectListener() {

            @Override
            public void onDisconnect(SocketIOClient socket) {
                String userId = socket.getHandshakeData().getUrlParams().get("userId").get(0);
                System.out.println("Socket is disconnected " + userId);
                connections.remove(userId);
            }    
        });        
    }
}
