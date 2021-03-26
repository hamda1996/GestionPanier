package com.gestionpanier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Context;
import org.zeromq.ZMQ.Socket;

import provider.ZeroMqProvider;

@SpringBootApplication
public class GestionPanierApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionPanierApplication.class, args);
		try {
			Context context = ZMQ.context(1);
			Socket output = context.socket(SocketType.REQ);
			output.connect("ipc://5000");
            while (!Thread.currentThread().isInterrupted()) {
            	String message = "Envoie moi le livre 1";
            	ZeroMqProvider.newStringMsg(message).send(output);
            	System.err.println("le message envoyé est : "+ message);
            	ZeroMqProvider receivedMessage = ZeroMqProvider.recvMsg(output);
    			System.err.println("le message reçu est : " + receivedMessage);
            }
		}catch (Exception e) {
			System.err.println("pffffffffff!!!" + e.getMessage());
		}
	}

}
