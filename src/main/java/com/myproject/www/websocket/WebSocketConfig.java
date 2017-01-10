//package com.myproject.www.websocket;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//
//@Configuration
//@EnableWebSocket//开启websocket
//public class WebSocketConfig implements WebSocketConfigurer {
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(new WebSocketHander(),"/echo").addInterceptors(new HandshakeInterceptor()).setAllowedOrigins("http://192.168.0.127"); //支持websocket 的访问链接
//        registry.addHandler(new WebSocketHander(),"/sockjs/echo").addInterceptors(new HandshakeInterceptor()).setAllowedOrigins("http://192.168.0.127").withSockJS(); //不支持websocket的访问链接
//    }
//}