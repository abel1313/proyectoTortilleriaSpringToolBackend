package com.empresa.Empresa.configCors;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

public class MyHandle extends BinaryWebSocketHandler
{

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) {
		// TODO Auto-generated method stub
		super.handleTextMessage(session, message);
	}
	
}
