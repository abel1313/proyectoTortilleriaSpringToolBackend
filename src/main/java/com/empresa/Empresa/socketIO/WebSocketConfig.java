package com.empresa.Empresa.socketIO;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import com.empresa.Empresa.configCors.MyHandle;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer
{

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
			registry.addHandler(myHandler(), "/empresa/sistema").setAllowedOrigins("http://127.0.0.1:4200");
	}
	
	@Bean
	public WebSocketHandler myHandler()
	{
		return new MyHandle();
	}
	@Bean
	public ServletServerContainerFactoryBean createWebSocketContainer()
	{
		ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
		container.setMaxTextMessageBufferSize(8192);
		container.setMaxBinaryMessageBufferSize(8192);
		return container;
	}

}
