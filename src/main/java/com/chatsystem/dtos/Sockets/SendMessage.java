package com.chatsystem.dtos.Sockets;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMessage {
    private String receiverId;
    private String message;
    private String senderId;
}
