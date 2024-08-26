package com.chatsystem.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.corundumstudio.socketio.SocketIOServer;

@Configuration
public class SocketConfig {
    

    @Value("${SOCKET_PORT}")
    private int socketPort;

    @Value("${SOCKET_HOST}")
    private String hostname;

    @Bean
    public SocketIOServer socketIOServer(){

        com.corundumstudio.socketio.Configuration configuration = new com.corundumstudio.socketio.Configuration();
        configuration.setPort(socketPort);
        configuration.setHostname(hostname);
        SocketIOServer server = new SocketIOServer(configuration);
        return server;
    }
}
