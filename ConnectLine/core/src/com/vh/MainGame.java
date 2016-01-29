package com.vh;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class MainGame extends Game {
	SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));

//		try {
////			URL url = new URL("localhost:9000/socket");
//			System.out.println("Hello connecting to socket");
//			Socket socket = new Socket("localhost", 9000);
//			System.out.println("Connected to "+ socket.getInetAddress());
//
//			PrintWriter out =
//					new PrintWriter(socket.getOutputStream(), true);
////			while(true) {
////				String line = in.readLine();
////				if (line !=null) {
////					System.out.println(line);
////				}
////			}
//		} catch (IOException e) {
//			System.out.println(e);
//		}

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				websocketTest();
			}
		});
		thread.start();

	}

	private void websocketTest() {
		try {
			URI uri = new URI("ws://localhost:9000/socket");

			WebSocketClient webSocketClient = new WebSocketClient(uri) {
				@Override
				public void onOpen(ServerHandshake handshakedata) {
					System.out.println("open!");
				}

				@Override
				public void onMessage(String message) {
					System.out.println(message);
				}

				@Override
				public void onClose(int code, String reason, boolean remote) {
					System.out.println("close");
				}

				@Override
				public void onError(Exception ex) {
					System.out.println("error");
				}
			};

			webSocketClient.connect();

			Scanner scanner = new Scanner(System.in);

			while(true) {
				String next = scanner.nextLine();
				System.out.println(next);
				webSocketClient.send(next);
			}

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render () {
		super.render();
	}
	//TODO using viewports, keeping the ratio the same.
}
